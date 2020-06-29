package com.rosetta.commons;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description apache commons StringUtils test
 * @Author nya
 * @Date 2020/3/3 上午10:10
 **/
public class StringUtilsTest {



    public static void main(String[] args) {
        String trim = StringUtils.trim("    abc  sdfs   ");
        System.out.println(trim);
        String base = "abcdefghijklmn";
        String truncate = StringUtils.truncate(base, 4);
        System.out.println(base);
        System.out.println(truncate);
        String truncate1 = StringUtils.truncate(base, 3, 4);
        System.out.println(base);
        System.out.println(truncate1);
        String substring = base.substring(1, 4);
        System.out.println(base);
        System.out.println(substring);

        String[] bjs = StringUtils.stripAll(base, "acb");
        System.out.println(StringUtils.join(bjs));

        int compare = StringUtils.compare("abc", "mnn");
        System.out.println(compare);
        int compare1 = StringUtils.compare("abc", "abc");
        int i = StringUtils.compareIgnoreCase("mn", "MN");
        System.out.println(compare1);
        System.out.println(i);

        int cde = StringUtils.indexOf(base, "cde");
        System.out.println(cde);
        boolean contains = StringUtils.contains(base, 97);
        System.out.println(contains);
        boolean containsTest = StringUtils.containsIgnoreCase(base,"A");
        System.out.println(containsTest);
    }

}
