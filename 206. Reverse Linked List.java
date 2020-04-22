Reverse a singly linked list.
Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

// 头节点不变的版本
public ListNode reverseList(ListNode head) {
    ListNode temp = head;
    while (temp != null && temp.next != null) {
        ListNode next = temp.next;
        temp.next = next.next;
        next.next = head;
        head = next;
    }
    return head;
}

// 头节点改变的版本
public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}

// 递归版本
public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
}
private ListNode reverseList(ListNode head, ListNode newHead) {
    if (head == null) {
        return newHead;
    }
    ListNode next = head.next;
    head.next = newHead;
    return reverseList(next, head);
}