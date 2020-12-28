package com.proxy;

/**
 * @Description 静态代理
 * 开后门加分
 * @Author nya
 * @Date 2020/7/6 下午2:10
 **/
public class ScoreOperateBackDoor implements ScoreOperate {
    private ScoreOperate operate;

    public ScoreOperateBackDoor(ScoreOperate operate) {
        this.operate = operate;
    }

    @Override
    public int randomScore(int base) {
        // base+10
        base = base + 10;
        // 原有逻辑
        int score = operate.randomScore(base);
        // 不满90 +10
        if (score <= 90) {
            score = score + 10;
        }
        return score;
    }

    @Override
    public int test() {
        return 0;
    }
}
