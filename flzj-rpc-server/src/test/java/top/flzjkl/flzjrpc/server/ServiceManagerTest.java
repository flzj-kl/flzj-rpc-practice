package top.flzjkl.flzjrpc.server;

import org.junit.Before;
import org.junit.Test;
import top.flzjkl.flzjrpc.common.utils.ReflectionUtils;
import top.flzjkl.flzjrpc.proto.Request;
import top.flzjkl.flzjrpc.proto.ServiceDescriptor;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ServiceManagerTest {
    private ServiceManager serviceManager;

    @Before
    public void init() {
        serviceManager = new ServiceManager();
/*        TestClass bean = new TestClass();
        serviceManager.register(TestInterface.class, bean);*/
    }

    @Test
    public void register() {
        TestClass testClass = new TestClass();
        serviceManager.register(TestInterface.class, testClass);
    }

    @Test
    public void lookup() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestInterface.class);
        Method method = publicMethods[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setServiceDescriptor(sdp);

        ServiceInstance sis = serviceManager.lookup(request);
        assertNotNull(sis);
    }
}