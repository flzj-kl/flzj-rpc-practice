package top.flzjkl.flzjrpc.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射工具类
 */
public class ReflectionUtils {
    /**
     * 根据class创建对象
     * @param clazz 待创建对象的类
     * @param <T>   对象类型
     * @return  创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个class的所有公共方法
     * @param clazz
     * @return  当前类声明的所有共公方法
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pMethods = new ArrayList<>();
        for(Method m : methods)
            if(Modifier.isPublic(m.getModifiers()))
                pMethods.add(m);
        return pMethods.toArray(new Method[0]);
        // return (Method[]) pMethods.toArray();
    }

    /**
     * 调用指定对象的指定方法
     * @param obj       被调用方法的对象
     * @param method    被调用的方法
     * @param arg       方法的参数
     * @return          返回结果
     */
    public static Object invoke(Object obj,Method method,Object... arg){
        try {
            return method.invoke(obj,arg);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
