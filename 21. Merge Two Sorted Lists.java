Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// 常规算法
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(-1);
    ListNode temp = result;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            result.next = new ListNode(l1.val);
            result = result.next;
            l1 = l1.next;
        } else {
            result.next = new ListNode(l2.val);
            result = result.next;
            l2 = l2.next;
        }
    }
    while (l1 != null) {
        result.next = new ListNode(l1.val);
        result = result.next;
        l1 = l1.next;
    }
    while (l2 != null) {
        result.next = new ListNode(l2.val);
        result = result.next;
        l2 = l2.next;
    }
    return temp.next;
}

// 递归算法
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}