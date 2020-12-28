package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 为确保隐蔽,不生成接口实现类的字节码,基于JVM动态代理的实现
 * Java8下的原生动态代理
 * @Author nya
 * @Date 2020/7/6 下午2:17
 **/
public class ScoreOperateBackDoorHandler implements InvocationHandler {
    private ScoreOperate operate;
    public ScoreOperateBackDoorHandler(ScoreOperate operate) {
        this.operate = operate;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int res = 0;
        args[0] = (int) args[0] + 10;
        if (method.getName().equals("randomScore")) {
            res = (int) method.invoke(operate,args);
        }
        if (res <= 90) {
            res = res + 10;
        }
        return res;
    }
}
