package top.flzjkl.flzjrpc.server;

import lombok.extern.slf4j.Slf4j;
import top.flzjkl.flzjrpc.proto.Request;
import top.flzjkl.flzjrpc.proto.ServiceDescriptor;
import top.flzjkl.flzjrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 表示暴露的服务
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass,T bean) {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : publicMethods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp,sis);
            log.info("register service: {} {}",sdp.getClazz(),sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getServiceDescriptor();
        return services.get(sdp);
    }
}
