package top.flzjkl.flzjrpc.server;

import top.flzjkl.flzjrpc.common.utils.ReflectionUtils;
import top.flzjkl.flzjrpc.proto.Request;

/**
 * 调用具体服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance serviceInstance, Request request) {
        return ReflectionUtils.invoke(serviceInstance.getTarget(),serviceInstance.getMethod(),
                request.getParameters());
    }
}
