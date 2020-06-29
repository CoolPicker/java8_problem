package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * @Author nya
 * @Date 2020/4/15 上午10:33
 **/
public class StockManagementSolution {

    private static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1;i++){
            for (int j = i+1;j < prices.length;j++) {
                int before = prices[i];
                int after = prices[j];
                if ((after - before) > max ) {
                    max = after - before;
                }
            }
        }
        return max;
    }

    private static int maxProfitLine(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0 ; i < prices.length;i++){
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }

    /**
     *
     *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        Map<Integer,Integer> intMap = new HashMap<>();
        for (int num :
                nums) {
            if (intMap.containsKey(num)) {
                intMap.put(num,intMap.get(num)+1);
            } else {
                intMap.put(num,1);
            }
        }
        return intMap.keySet().stream().filter( item -> intMap.get(item) > nums.length/2).collect(Collectors.toList()).get(0);
    }

    /**
     * 投票方式
     * @param nums
     * @return
     */
    private static int majorityElementTwo(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int item : nums) {
            if (count == 0){
                candidate = item;
            }
            count += (candidate == item ? 1 : -1);
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] test = {7,6,4,3,1,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(test));
    }
}
