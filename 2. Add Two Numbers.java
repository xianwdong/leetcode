// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode cur = head;
    int carry = 0, sum = 0;
    while (l1 != null && l2 != null) {
        sum = (l1.val + l2.val + carry) % 10;
        carry = (l1.val + l2.val + carry) / 10;
        ListNode node = new ListNode(sum);
        cur.next = node;
        cur = node;
        l1 = l1.next;
        l2 = l2.next;
    }
    while (l1 != null) {
        sum = (l1.val + carry) % 10;
        carry = (l1.val + carry) / 10;
        ListNode node = new ListNode(sum);
        cur.next = node;
        cur = node;
        l1 = l1.next;
    }
    while (l2 != null) {
        sum = (l2.val + carry) % 10;
        carry = (l2.val + carry) / 10;
        ListNode node = new ListNode(sum);
        cur.next = node;
        cur = node;
        l2 = l2.next;
    }
    if (carry == 1) {
        ListNode node = new ListNode(1);
        cur.next = node;
        cur = node;
    }
    return head.next;
}

// pretty codes
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode c1 = l1;
    ListNode c2 = l2;
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    int sum = 0;
    while (c1 != null || c2 != null) {
        sum /= 10;
        if (c1 != null) {
            sum += c1.val;
            c1 = c1.next;
        }
        if (c2 != null) {
            sum += c2.val;
            c2 = c2.next;
        }
        d.next = new ListNode(sum % 10);
        d = d.next;
    }
    if (sum / 10 == 1) {
        d.next = new ListNode(1);
    }
    return sentinel.next;
}