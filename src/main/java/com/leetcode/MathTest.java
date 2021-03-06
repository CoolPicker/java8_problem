package com.leetcode;

/**
 * @Description Math相关函数
 *
 * 1.火车从A站经过1小时10分钟到达B站，
 * 在A站上车的旅客使原本25%的上座率提高到87.5%，
 * 所有刚上车的旅客都要进行体温测量，
 * 已知测量体温每人耗时10秒，
 * 若从开车起到B站时刚好测完所有新上车的旅客，
 * 则这趟火车总共能承载的旅客人数是多少?
 *
 * A.480     B.640     C.672     D.1120
 *
 * 2.甲、乙、丙三人在一起比年龄，甲对丙说：我像你这么大的时候，还没有你呢;乙对甲说：我像你这么大的时候，你也才8岁啊。已知今年乙的年龄是丙的6倍，是甲的1.5倍，问甲今年多少岁?
 *
 * A.12     B.16     C.20    D.24
 *
 * 3.一批零件，王师傅单独加工需要30天完工。
 * 若王师傅单独加工5天后，赵师傅加入，两人合作6天，
 * 此时已加工的零件与未加工的零件个数之比为2：3。
 * 为了尽快完工，李师傅前来帮忙，三人合作加工9天，
 * 此时还剩余15%的工作量。
 * 若三人合作，需多少天才能完工?
 *
 * A.18     B.20     C.22     D.24
 *
 *
 * 1、现在有一堆苹果，分给一群人，每个人分3个，剩2个;每个人分4个，剩2个，那么这堆苹果至少有多少个( )?
 *
 * A.14 B.21 C.22 D.26
 *
 * 2、某人数约为500人的工厂，现公司人力资源要统计人数，已知该厂人数除以6余3，除以7余2，除以8余1，求该厂共有多少人?
 *
 * A.483 B.502 C.513 D.544
 *
 * 3、三位运动员跨台阶，台阶总数在100-150级之间，第一位运动员每次跨3级台阶，最后一步还剩2级台阶。第二位运动员每次跨4级台阶，最后一步还剩3级台阶。第三位运动员每次跨5级台阶，最后一步还剩4级台阶。问：这些台阶总共有多少级?
 *
 * A.119 B.121 C.129 D.131
 *
 * 1、五个人手拉手围成一圈，问共有多少种不同的方法?
 *
 * A.24 B.12 C.6 D.3
 *
 * 2、四对夫妇坐在圆桌旁，要求每对夫妇必须坐在一起，则座位有多少种不同的安排方法?
 *
 * A.96 B.48 C.192 D.384
 *
 * @Author nya
 * @Date 2020/7/29 下午3:50
 **/
public class MathTest {
    public static void main(String[] args) {
        // 取绝对值
        Math.abs(12.3);
        Math.abs(-12.3);

        // 第一个参数的量值 + 第二个参数的符号
        Math.copySign(1.23,-12.3);
        Math.copySign(-1.23,-12.3);

        // 参数 > 0 返回 1.0
        // 参数 < 0 返回 -1.0
        // 参数 = 0 返回 0
        Math.signum(123);
        Math.signum(-12.3);
        Math.signum(0);

        // 取整
        Math.ceil(12.3);
        Math.floor(12.3);
        Math.round(12.3);

        // 比较大小
        Math.max(123,120);
        Math.min(123,120);

        // 三角函数
        double sin = Math.sin(Math.PI / 6);
        double cos = Math.cos(Math.PI / 3);
        double tan = Math.tan(Math.PI / 4);

        // 求角
        double asin = Math.asin(0.5);
        double acos = Math.acos(0.5);
        double atan = Math.atan(1);

        // 根据sin计算夹角
        System.out.println((int) (Math.asin(0.5) / Math.PI * 180));
    }
}
