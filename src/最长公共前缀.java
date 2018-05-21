/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());

        int left = 1, right = minLen;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (isCommonPrefix(strs, middle))
                left = middle + 1;
            else
                right = middle - 1;
        }

        return strs[0].substring(0, (left + right) / 2);
    }

    public boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        最长公共前缀 test = new 最长公共前缀();
        System.out.println(test.longestCommonPrefix(strs));
    }
}