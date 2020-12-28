package com.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description Stream方法测试
 * @Author nya
 * @Date 2020/4/7 下午2:08
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "983", "333", "666", "432", "520", "333", "099","abc");
        List<Integer> integers = list.stream().filter(StringUtils::isNumeric).mapToInt(Integer::parseInt).boxed().sorted().collect(Collectors.toList());
        System.out.println(integers);
//        List<String> filterChars = list.stream().filter(StringUtils::isNumeric).collect(Collectors.toList());
//        System.out.println(filterChars);
//        List<Integer> pluralNumList = filterChars.stream().filter(e -> {
//            String[] split = e.split("");
//            String one = null;
//            for (String each :
//                    split) {
//                if (one != null) {
//                    if (!one.equals(each)) {
//                        return false;
//                    }
//                }
//                one = each;
//            }
//            return true;
//        }).map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(pluralNumList);
//        List<Integer> collect = Stream.generate(() -> new Random().nextInt()).limit(5).collect(Collectors.toList());
//        System.out.println(collect);
//        System.out.println(collect.stream().max(Integer::compareTo));
//        System.out.println(collect.stream().min(Integer::compareTo));
//        System.out.println(collect.stream().findAny().get());
//
//        list.forEach(item -> {
//            System.out.println(item.length());
//            System.out.println(3);
//        });
    }


}
