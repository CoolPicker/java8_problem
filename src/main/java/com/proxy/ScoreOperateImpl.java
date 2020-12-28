package com.proxy;

import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description
 * @Author nya
 * @Date 2020/7/6 下午1:57
 **/
public class ScoreOperateImpl implements ScoreOperate {

    @Override
    public int randomScore(int base) {
        if (base > 50) {
            return base;
        } else {
            int bound = (100 - base) / 2;
            // 生成随机数 ThreadLocalRandom 0-49
            int first = ThreadLocalRandom.current().nextInt(bound);
            // 并发场景下(Fork Join Pool / 并行stream), SplittableRandom
            SplittableRandom random = new SplittableRandom();
            int second = random.nextInt(bound);
            return base + first + second;
        }
    }

    @Override
    public int test() {
        return 0;
    }
}
