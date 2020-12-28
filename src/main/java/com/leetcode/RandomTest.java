package com.leetcode;

import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/13 下午5:17
 **/
public class RandomTest {

    public static void main(String[] args) {

        int bound = 100;
        // 生成随机数 ThreadLocalRandom 0-49
        int first = ThreadLocalRandom.current().nextInt(bound);
        // 并发场景下(Fork Join Pool / 并行stream), SplittableRandom
        SplittableRandom random = new SplittableRandom();
        int second = random.nextInt(bound);
        System.out.println(first + " - " + second);

    }

}
