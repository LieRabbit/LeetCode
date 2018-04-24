import java.util.HashMap;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // 记录字符上次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // 最近出现重复字符的位置
        int pre = -1;

        for (int i = 0, strLen = str.length(); i < strLen; i++) {
            Character ch = str.charAt(i);
            Integer index = map.get(ch);
            if (index != null)
                pre = Math.max(pre, index);
            max = Math.max(max, i - pre);
            map.put(ch, i);
        }

        return max;
    }

    public static void main(String[] args) {
        无重复字符的最长子串 test = new 无重复字符的最长子串();
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }
}
