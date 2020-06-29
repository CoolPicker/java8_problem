package com.leetcode;

/**
 * @Description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 杜十娘 卓依婷
 * 孤灯夜下 我独自一人坐船舱
 * 船舱里有我杜十娘 在等着我的郎
 * 忽听窗外 有人叫杜十娘
 * 手扶着窗栏四处望 怎不见我的郎
 * 啊 郎君啊 你是不是饿得慌
 * 如果你饿得慌 对我十娘讲 十娘我给你做面汤
 * 郎君啊 你是不是冻得慌
 * 你要是冻得慌 对我十娘讲 十娘我给你做衣裳
 * 啊 郎君啊 你是不是闷得慌
 * 你要是闷得慌 对我十娘讲 十娘我为你解忧伤
 * 郎君啊 你是不是想爹娘
 * 你要是想爹娘 对我十娘讲 十娘我跟你回家乡
 * 啊 郎君啊 你是不是困得慌
 * 你要是困得慌 对我十娘讲 十娘我扶你上竹床
 * 十娘呀杜十娘 手捧着百宝箱
 * 纵身投进滚滚长江 再也不见我的郎 啊
 *
 * @Author nya
 * @Date 2020/6/29 下午2:39
 **/
public class LongestPalindrome5 {
    public static void main(String[] args) {
        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        LongestPalindrome5 palindrome = new LongestPalindrome5();
        String s = palindrome.longestPalindrome(a);
        System.out.println(s);
//        boolean b = palindrome.checkPalindrome(a);
//        System.out.println(b);
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i,j] 是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0 ; i < s.length();i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < s.length();j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立,就表示子串 s[i..j] 是回文,此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin + maxLen);
    }

    /**
     * 暴力求解
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String longest = "";
        for (int i = 0 ; i < s.length() - 1;i++) {
            for (int j = i + 1;j<=s.length();j++) {
                String substring = s.substring(i, j);
                if (substring.length() < longest.length()) continue;
                if (checkPalindrome(substring)) {
                    if (substring.length() > longest.length()) {
                        longest = substring;
                    }
                }
            }
        }
        if (longest.equals("") && s.length() == 1) longest = s;
        return longest;
    }

    private boolean checkPalindrome(String str) {
        for (int i = 0 ; i <= str.length() / 2; i ++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
