package com.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.apache.commons.lang3.time.StopWatch;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @Description 测试类
 * @Author nya
 * @Date 2020/7/6 下午2:13
 **/
public class ScoreOperateTest {

    public static void main(String[] args) throws Exception {
        ScoreOperate operate = new ScoreOperateImpl();
        // 设置保存jdk代理对象生成的类文件 com.sun.proxy 下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 开启 保存cglib生成的动态代理类类文件
        saveGeneratedCGLIBProxyFiles("/home/lab/git_0/java8_problem/com/sun/proxy/");
        int count = 1000000;
        // 静态代理
        StopWatch watch = StopWatch.createStarted();
        for (int i = 0 ; i < count; i++) {
            ScoreOperate staticProxy = new ScoreOperateBackDoor(operate);
            int score = staticProxy.randomScore(20);
//            System.out.println(score);
            int scoreRandom = staticProxy.randomScore(45);
//            System.out.println(scoreRandom);
        }
        System.out.println(watch.getNanoTime());
        watch.reset();
        watch.start();

        // JVM实现的动态代理
        for (int i = 0; i < count; i++) {
            ScoreOperateBackDoorHandler handler = new ScoreOperateBackDoorHandler(operate);
            ScoreOperate dynamicProxy = (ScoreOperate) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[]{ScoreOperate.class}, handler);
            int score2 = dynamicProxy.randomScore(20);
//            System.out.println(score2);
            int randomScore = dynamicProxy.randomScore(45);
//            int test = dynamicProxy.test();
//            System.out.println(randomScore);
        }
        System.out.println(watch.getNanoTime());
        watch.reset();
        watch.start();

        // cglib实现的动态代理
        for (int i = 0 ; i < count; i++) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(ScoreOperateImpl.class);
            enhancer.setCallback(new ScoreOperateBackDoorInterceptor());
            // 此处可强转为接口,也可以强转为目标类
            ScoreOperateImpl dynamicProxyCglib = (ScoreOperateImpl) enhancer.create();
            int score3 = dynamicProxyCglib.randomScore(20);
//            System.out.println(score3);
            int randomScore2 = dynamicProxyCglib.randomScore(45);
//            System.out.println(randomScore2);
        }
        System.out.println(watch.getNanoTime());
        watch.stop();

    }

    static void saveGeneratedCGLIBProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }

}
