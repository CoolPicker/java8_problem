package com.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description 自定义MethodInterceptor
 * cglib 实现动态代理
 * @Author nya
 * @Date 2020/7/6 下午2:45
 **/
public class ScoreOperateBackDoorInterceptor implements MethodInterceptor {
    /**
     * @param o cglib生成的代理对象
     * @param method 被代理对象方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return 结果
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        int res = 0;
        objects[0] = (int) objects[0] + 10;
        if (method.getName().equals("randomScore")) {
            res = (int) methodProxy.invokeSuper(o,objects);
        }
        if (res <= 90) {
            res = res + 10;
        }
        return res;
    }
}
