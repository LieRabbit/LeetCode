/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 为方便操作加入的头节点
        ListNode res = new ListNode(0);
        // 当前节点
        ListNode cur = res;
        // 进位标志
        boolean[] flag = new boolean[1];

        // 两链表对应位置相加
        while (l1 != null && l2 != null) {
            ListNode node = add(l1.val, l2.val, flag);
            cur.next = node;
            cur = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        // 如果l1链表有剩余，则剩下的与0相加
        while (l1 != null) {
            ListNode node = add(l1.val, 0, flag);
            cur.next = node;
            cur = node;
            l1 = l1.next;
        }

        // 如果l2链表有剩余，则剩下的与0相加
        while (l2 != null) {
            ListNode node = add(0, l2.val, flag);
            cur.next = node;
            cur = node;
            l2 = l2.next;
        }

        // 如果链表末尾相加有进位则添加一个进位节点作为尾节点
        if (flag[0])
            cur.next = new ListNode(1);

        return res.next;
    }

    public ListNode add(int v1, int v2, boolean[] flag) {
        int sum = v1 + v2;
        // 如果有进位则和+1
        if (flag[0]) {
            sum++;
            flag[0] = false;
        }
        // 产生进位
        if (sum > 9)
            flag[0] = true;
        // 获取个位上的数
        return new ListNode(sum % 10);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 为方便操作加入的头节点
        ListNode res = new ListNode(0);
        // 当前节点
        ListNode cur = res;
        // 进位
        int carry = 0;

        // 两链表对应相加
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            // 获取进位
            carry = sum / 10;
            // 获取个位上的数
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return res.next;
    }


    public static void main(String[] args) {
        两数相加 test = new 两数相加();

        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
//        ListNode l13 = new ListNode(3);
        l11.next = l12;
//        l12.next = l13;

        ListNode l21 = new ListNode(1);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;

        ListNode res = test.addTwoNumbers2(l11, l21);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}