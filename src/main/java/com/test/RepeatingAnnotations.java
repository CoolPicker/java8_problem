package com.test;

import java.lang.annotation.*;
import java.util.*;

/**
 * @Description 重复注解
 * @Author nya
 * @Date 2020/4/3 上午11:37
 **/
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class) // 允许重复注解, 指定 容器holder为Filters
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable{}

    public static void main(String[] args) {

        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }

        List<String> list = Arrays.asList("a","b","c","d");
        List<String> mmList = new ArrayList<>();
        list.forEach( e -> {
            String mm = e + "-mm";
            mmList.add(mm);
        });
        mmList.stream().forEach(e -> {
            System.out.println(Thread.currentThread() + " --- " + e + " stream()");
        });
        mmList.parallelStream().forEach(e -> {
            System.out.println(Thread.currentThread() + " --- " + e + " parallelStream()");;
        });
        mmList.removeIf(e -> e.contains("b"));
        System.out.println(mmList);

    }
}
