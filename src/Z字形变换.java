/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 实现一个将字符串进行指定行数变换的函数:
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder();

        int index = 0, len = s.length();
        while (index < len) {
            for (int row = 0; row < numRows && index < len; row++) // 往下走
                sbs[row].append(s.charAt(index++));
            for (int row = numRows - 2; row > 0 && index < len; row--) // 往上走
                sbs[row].append(s.charAt(index++));
        }

        for (int row = 1; row < numRows; row++)
            sbs[0].append(sbs[row]);

        return sbs[0].toString();
    }

    public static void main(String[] args) {
        Z字形变换 test = new Z字形变换();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
