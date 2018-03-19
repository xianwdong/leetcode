/*Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?*/

public boolean hasCycle(ListNode head) {
    if (head == null) {
        return false;
    }
    ListNode head1 = head, head2 = head.next;
    while (head1 != head2 && head2 != null) {
        head1 = head1.next;
        if (head2.next == null) {
            return false;
        }
        head2 = head2.next.next;
    }
    return head2 != null;
}