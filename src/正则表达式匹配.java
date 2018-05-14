/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        return isMatchCore(s, 0, p, 0);
    }

    public boolean isMatchCore(String s, int sIndex, String p, int pIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (s.length() == sIndex && p.length() == pIndex)
            return true;
        // pattern先到尾，匹配失败
        if (p.length() == pIndex)
            return false;
        // 模式后一个字符是*，且字符串第1个跟模式第1个匹配,分2种匹配模式。如不匹配，模式后移2位
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                return isMatchCore(s, sIndex + 1, p, pIndex) || // x*匹配1个字符，再匹配str中的下一个
                        isMatchCore(s, sIndex, p, pIndex + 2); // 模式后移2位，视为x*匹配0个字符
            } else
                return isMatchCore(s, sIndex, p, pIndex + 2);
        } else {
            // 模式后一个字符不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            if (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.'))
                return isMatchCore(s, sIndex + 1, p, pIndex + 1);
            else
                return false;
        }
    }

    public boolean isMatch2(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*')
            return isMatch2(s, p.substring(2)) || (firstMatch && isMatch2(s.substring(1), p));
        else
            return firstMatch && isMatch2(s.substring(1), p.substring(1));
    }


    public static void main(String[] args) {
        正则表达式匹配 test = new 正则表达式匹配();
        System.out.println(test.isMatch2("ab", ".*"));
    }
}
