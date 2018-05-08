/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        // 改造字符串
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0, len = s.length(); i < len; i++)
            sb.append("#").append(s.charAt(i));
        sb.append("#$");

        int c = 0, r = 0, len = sb.length(), centerIndex = 0, maxLen = 0;
        int[] p = new int[len];

        for (int i = 1; i < len - 1; i++) {
            int iMirror = 2 * c - i; // 相当于 c - (i - c)

            p[i] = r > i ? Math.min(r - i, p[iMirror]) : 0;

            // 基于当前点为中心扩展寻找回文
            while (sb.charAt(i - 1 - p[i]) == sb.charAt(i + 1 + p[i]))
                p[i]++;

            // 如果扩展后的右边界值大于当前右边界值则更新
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            // 寻找最大值与中心点
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int beginIndex = (centerIndex - 1 - maxLen) / 2;

        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public static void main(String[] args) {
        最长回文子串 test = new 最长回文子串();
        System.out.println(test.longestPalindrome("babad"));
    }
}
