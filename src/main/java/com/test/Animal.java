package com.test;

/**
 * 617
 * 1、.甲乙两人分别从A、B两地同时出发，相向而行，甲的速度为60km/h，乙的速度为40km/h，甲乙两人5小时后相遇，问A、B两地的距离为多少千米?
 *  C
 * A.200 B. 300 C.500 D.600
 *
 * 2、南京到上海的水路长392千米，同时从两港各开出一艘轮船相对而行，从南京开出的船每小时行28千米，从上海开出的船每小时行21千米，经过几小时两船相遇?
 *  C
 * A.6 B.7 C.8 D.9
 *
 * 3、甲乙两人分别从A、B两地同时出发，同向而行，A、B两地间的距离为500km，甲的速度为60km/h，乙的速度为40km/h，问甲追上乙需要多少小时?
 *  A
 * A.25 B.26 C.27 D.28
 *
 * 610
 * 1、小戴业余时间补贴家用，到手工艺品厂帮忙串手链。每制作一个合格品工费8元，每制作一个次品扣5元。本周小戴制作100个领到工钱735元，问他制作的产品合格率是多少?
 *  D
 * A 80% B 85% C 90% D 95%
 *
 * 2、一工程甲独自做需60天，甲乙合作需36天，乙丙合作需要30天。请问丙单独做需多少天?
 *  C
 * A 40 B 42 C 45 D 48
 *
 * 3、A B两地相距300km，甲车在A地，乙车在B地，甲的速度40km/h，乙的速度60km/h，相向而行，在甲出发前乙先行1小时。问两车相遇时乙共走多远?
 *  C
 * A 196 km B 200 km C 204 km D 208 km
 *
 * 603
 *
 * 1、某机关20人参加百分制的普法考试，及格线为60分，20人的平均成绩为88分，及格率为95%。所有人得分均为整数，且彼此得分不同。问成绩排名第十的人最低考了多少分?
 *  B
 * A.88 B.89 C.90 D.91
 *
 * 2、某部队从驻地乘车赶往训练基地，如果车速为54公里/小时，正好准点到达;如果将车速提高1/9，就可以比预定的时间提前20分钟赶到;如果将车速提高1/3，可比预定的时间提前多少分钟赶到?
 *  C
 * A.30 B.40 C.50 D.60
 *
 * 527
 *
 * 1、现共有100人参加公司的招聘考试，考试内容共有5道题，1-5题分别有80人、92人、86人、78人、74人答对，规定答对3道及3道以上的人能通过招聘考试，问至少有几个人通过本次招聘考试?( )
 *  C
 * A.30 B.55 C.70 D.74
 *
 * 2、书法大赛的观众对5幅作品进行不记名投票。
 * 每张选票都可以选择5幅作品中的任意一幅或多幅，但只有在选择不超过2幅作品时才为有效票。
 * 5幅作品的得票数(不考虑是否有效)分别为总票数的69%、63%、44%、58%和56%。则本次投票的有效率最高可能为多少?( )
 *  B
 * A.65% B.70% C.75% D.80%
 *
 * 513
 * 1、某商场销售一款时装，若将进价的20%作为利润，则售价为240元。若该时装售价变为300元，此时的利润率是：
 *  A
 * A.50% B.45% C.40% D.35%
 *
 * 2、某产品的售价为67.1元，在采用新技术之后生产成本节约了10%，在售价不变的情况下，利润变成了原来的两倍。那么产品最初的成本是多少元?
 *  C
 * A.51.2 B.54.9 C.61 D.62.5
 * 题目中在售价不变的情况下，由于成本降低了，所以后来的利润变为原来的两倍，那么等量关系我们就找到了，只要假设成本为未知数这道题目就解决了。
 * 所以假设成本为a,可以有 2(67.1 - a)= 67.1 - 0.9a，解方程可得成本a = 61。
 *
 * 3、甲乙俩商店以相同的成本进购一种商品，甲按照赚25%的利润卖出去，乙以亏本11%卖出去，那么当甲卖出2件，乙卖出3件的时候，两家商店总体的盈利为：
 *  B
 * A.3.2% B.3.4% C.3.6% D.4%
 */
public interface Animal {

    void speak();

    default String category(String name) {
        System.out.print("I am ");
        System.out.println(name);
        return name;
    }

    default String eat(String food) {
        System.out.println("I am hungry!");
        System.out.println(food);
        return food;
    }

}
