package com.lizz.fundation.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author lizz365
 */
public class LengthOfLongestSubstring {
    /**
     * 暴力法
     * 时间复杂度：O(n3)
     * 空间复杂度：O(min(n,m))
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOn3(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
        return ans;
    }
    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(2n)
     * 空间复杂度：O(min(n,m))
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringO2n(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化滑动窗口
     * 时间复杂度：O(n)，索引j将会迭代n次。
     * 空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
     * 空间复杂度（Table）：O(m)，m 是字符集的大小。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
       /* String str = "abababasvba";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(str));
*/
        System.out.println(Math.max(5, 6));
    }

}
