package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 尝试动态规划实现
 *
 * @Author nya
 * @Date 2020/7/10 下午2:09
 **/
public class MaxProfit309 {


    public static void main(String[] args) {
        MaxProfit309 max = new MaxProfit309();
        int[] prices = {1,4,2};
        int i = max.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        List<IndexEach> items = valleyBottomArray(prices);
        int total = 0;
        boolean hasBrother = false;
        int itemStart = -1;
        int itemEnd = 0;
        for (int i = 0; i < items.size();i++){
            IndexEach item = items.get(i);
            if (i == items.size() - 1) {
                if (!item.isValley() && itemStart >= 0){
                    total+=(prices[item.getIndex()] - prices[itemStart]);
                }
                break;
            }

            IndexEach after = items.get(i + 1);
            boolean valley = item.isValley();
            boolean afterValley = after.isValley();
            if (valley == afterValley){
                // 后边有兄弟
                hasBrother = (prices[item.getIndex()] == prices[after.getIndex()]);
                continue;
            }
            if (valley) {
                itemStart = item.getIndex();
            }
            if (!valley && itemStart >= 0) {
                itemEnd = item.getIndex();
                if (hasBrother) {
                    total += (prices[itemEnd] - prices[itemStart]);
                } else {
                    if ((after.getIndex() - itemEnd == 1 && i == items.size() - 2 && !items.get(items.size()-1).isValley) || (after.getIndex() - itemEnd == 1 && i < items.size()-2 && !items.get(i+2).isValley) ) {
                        total += (prices[itemEnd-1] - prices[itemStart]);
                    } else {
                        total += (prices[itemEnd] - prices[itemStart]);
                    }
                }
            }
        }
        return total;
    }

    /**
     * 取坑
     * @param prices
     * @return
     */
    public List<IndexEach> valleyBottomArray(int[] prices) {
        List<IndexEach> res = new ArrayList<>();
        for (int i = 0 ; i < prices.length; i++) {
            IndexEach each = new IndexEach();
            each.setIndex(i);
            if (i == 0) {
                int zero = prices[i];
                int first = prices[i+1];
                if (first > zero) {
                    each.setValley(true);
                    res.add(each);
                } else {
                    each.setValley(false);
                    res.add(each);
                }
            } else if (i == prices.length - 1) {
                int before = prices[i-1];
                int zero = prices[i];
                if (zero < before) {
                    each.setValley(true);
                    res.add(each);
                } else {
                    each.setValley(false);
                    res.add(each);
                }
            } else {
                int before = prices[i-1];
                int zero = prices[i];
                int after = prices[i+1];
                if ((before >= zero) && (after > zero)) {
                    each.setValley(true);
                    res.add(each);
                } else if ((before < zero) && after <= zero) {
                    each.setValley(false);
                    res.add(each);
                }
            }
        }
        return res;
    }


    private static class IndexEach {
        int index;
        boolean isValley;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isValley() {
            return isValley;
        }

        public void setValley(boolean valley) {
            isValley = valley;
        }

        @Override
        public String toString() {
            return "IndexEach{" +
                    "index=" + index +
                    ", isValley=" + isValley +
                    '}';
        }
    }

}
