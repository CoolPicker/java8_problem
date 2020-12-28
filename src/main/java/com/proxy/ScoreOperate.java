package com.proxy;

/**
 * 随机分数查询
 */
public interface ScoreOperate {

    /**
     * 随机生成分数 0-100
     * @param base 最低分
     * @return 最终分数
     */
    public int randomScore(int base);

    public int test();

}
