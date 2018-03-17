/*Given a linked list, remove the nth node from the end of list and return its head.
For example,
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode head1 = head, head2 = head;
    for (int i = 0; i < n; ++i) {
        head1 = head1.next;
    }
    if (head1 == null) {
        return head.next;
    }
    while (head1.next != null) {
        head1 = head1.next;
        head2 = head2.next;
    }
    head2.next = head2.next.next;
    return head;
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}