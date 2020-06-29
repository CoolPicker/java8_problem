package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Author nya
 * @Date 2020/6/29 下午1:55
 **/
public class LengthOfLongestSubString3 {
    public static void main(String[] args) {
        String a = "pwwkew";
        LengthOfLongestSubString3 string = new LengthOfLongestSubString3();
        int length = string.lengthOfLongestSubstring(a);
        System.out.println(length);
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {



        return 0;
    }

    /**
     * 暴力求解
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        String[] split = s.split("");
        int longest = 0;
        for (int i = 0 ; i < s.length();i++){
            Set<String> set = new HashSet<>();
            String a = split[i];
            set.add(a);
            for (int j = i + 1;j<s.length();j++) {
                String b = split[j];
                if (j > i) {
                    if (!set.contains(b)) {
                        set.add(b);
                    } else {
                        break;
                    }
                }
            }
            if (set.size() >= longest) {
                longest = set.size();
            }
        }
        return longest;
    }


}
