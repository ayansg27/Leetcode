public class reverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode current=head,chk=null,prev=null;
        while(current!=null){
            chk=current.next;
            current.next=prev;
            prev=current;
            current=chk;
        }
        return prev;
    }
	
}
