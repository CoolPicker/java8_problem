package com.daily;

/**
 * @Description
 * @Author nya
 * @Date 2020/5/20 下午2:12
 **/
public class PensionCalculate {

    // 定期存款年化利率
    private static double yearRate = 0.038;

    // 定期存款月化利率
    private static double monthRate = yearRate / 12;

    public static void main(String[] args) {
        // 入保年龄
        int joinYear = 27;
        // 退休年龄
        int lastYear = 55;
        // Over年龄
        int lineYear = 65;
        // 总参保月份
        int totalMonth = (lastYear - joinYear) * 12;

        // 总参保金额
        long firstStageTotal = 0;
        for (int i = 1; i <= totalMonth; i++) {
            int exponent = totalMonth - i;
            firstStageTotal = firstStageTotal + Math.round(1000 * Math.pow((1 + monthRate), exponent));
        }
        System.out.println("截止到55岁总参保金额: " + firstStageTotal);
        System.out.println("55岁当年总利息: " + Math.round(firstStageTotal * yearRate));
        System.out.println("55岁当年每月利息: " + Math.round(firstStageTotal * yearRate / 12));

        // 总花去月份
        int costMonth = (lineYear - lastYear) * 12;

        int shallCost = 0;

        for (int monthCost = 1000; monthCost < 100000; monthCost++) {
            long total = firstStageTotal;
            for (int i = 1; i <= costMonth; i++) {
                total = total - monthCost;
                total = Math.round(total * (1 + monthRate));
            }
            if (total < 0) {
                shallCost = monthCost;
                break;
            }
        }

        long all = firstStageTotal;
        int mustCostMonth = 0;
        int classicMonthCost = 2146;
        while (all > 0) {
            all = all - classicMonthCost;
            all = Math.round(all * (1 + monthRate));
            mustCostMonth++;
        }
        System.out.println("活到"+ lineYear +"岁应日取金额: " + shallCost);
        System.out.println("应该活到"+(int)(lastYear + Math.floor(mustCostMonth / 12))+"岁零"+mustCostMonth%12+"个月才够本");
    }

}
