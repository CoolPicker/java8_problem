package com.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 12%3 21sdas s34d dfsdz45 R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd
 *  求取字符串中所有数字之和
 * @Author nya
 * @Date 2020/4/7 上午10:33
 **/
public class StringNumberSumTest {

    private static String strings = "12%3 21sdas s34d dfsdz45 R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        StringBuilder now = new StringBuilder();
        for (String each :
                strings.split("")) {
            if (StringUtils.isNumeric(each)) {
                now.append(each);
            } else {
                String here = now.toString();
                if (StringUtils.isNotBlank(here)) {
                    integers.add(Integer.parseInt(here));
                    now = new StringBuilder();
                }
            }
        }
        System.out.println(integers);

        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);


    }

}
