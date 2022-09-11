package top.flzjkl.flzjrpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(testClass);
    }

    @Test
    public void getPublicMethods() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(2,publicMethods.length);

        String name = publicMethods[0].getName();
        assertEquals("c",name);
    }

    @Test
    public void invoke() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method publicMethodC = publicMethods[0];
        assertEquals("c",ReflectionUtils.invoke(new TestClass(),publicMethodC));
    }
}