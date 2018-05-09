/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class 反转整数 {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int remainder = x % 10;
            int newRes = res * 10 + remainder;
            if ((newRes - remainder) / 10 != res) // 如果有溢出则无法回退到原来的结果
                return 0;
            res = newRes;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        反转整数 test = new 反转整数();

        System.out.println(test.reverse(321));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
    }
}
