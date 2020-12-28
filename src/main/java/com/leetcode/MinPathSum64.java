package com.leetcode;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，
 * 请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @Author nya
 * @Date 2020/7/23 下午2:29
 **/
@Slf4j
public class MinPathSum64 {

    public static void main(String[] args) {
        // Logback设置日志级别
        LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();
        //设置全局日志级别
        ch.qos.logback.classic.Logger logger=loggerContext.getLogger("root");
        logger.setLevel(Level.toLevel("info"));
        int tom = 999;
        long a = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            log.debug("aaa {}",tom);
//            if (log.isDebugEnabled()){
//                log.debug("haha {}",tom);
//            }

        }
        long b = System.nanoTime();
        System.out.println(b-a);

    }

    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
