package com.pan.instance;

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class No2 {

    public static void solution() {
        ListNode l1 = new ListNode(0);
        //l1.next = new ListNode(9);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2, 1);
        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int way) {
        switch (way) {
            case 1:
                return addTwoNumber1(l1, l2);
//            case 2:
//                return twoSum2(l1, l2);
//            case 3:
//                return twoSum3(l1, l2);
        }
        return null;
    }

    private static ListNode addTwoNumber1(ListNode l1, ListNode l2) {
        boolean flag = true;
        ListNode first = new ListNode(0);
        ListNode last = first;
        int bit = 0;
        while (flag) {
            int l = 0;
            if (null != l1) {
                l = l1.val;
                l1 = l1.next;
            }
            int r = 0;
            if (null != l2) {
                r = l2.val;
                l2 = l2.next;
            }
            int tmp = l + r + bit;
            if (tmp > 9) {
                bit = tmp / 10;
                tmp = tmp % 10;
            } else {
                bit = 0;
            }
            last.val = tmp;
            if (l1 == null && l2 == null) {
                if (0 != bit) {
                    last.next = new ListNode(bit);
                }
                flag = false;
            } else {
                last = last.next = new ListNode(0);
            }

        }
        return first;
    }
}
