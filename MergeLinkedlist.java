public class MergeLinkedlist {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode comb=null,combHead=null;
        while(l1!=null||l2!=null){
            if(comb==null){
                if(l1==null){
                    comb=l2;
                    combHead=l2;
                    l2=l2.next;  
                }
                else if(l2==null){
                    comb=l1;
                    combHead=l1;
                    l1=l1.next;
                }
                else if(l1.val<l2.val){
                    comb=l1;
                    combHead=l1;
                    l1=l1.next;
                }
                else{
                    comb=l2;
                    combHead=l2;
                    l2=l2.next; 
                }
            }
            else if(l1==null){
                comb.next=l2;
                comb=comb.next;
                l2=l2.next;
            }
            else if(l2==null){
                comb.next=l1;
                comb=comb.next;
                l1=l1.next;
            }
            else{
                if(l1.val<l2.val){
                    comb.next=l1;
                    comb=comb.next;
                    l1=l1.next;
                }
                else{
                    comb.next=l2;
                    comb=comb.next;
                    l2=l2.next; 
                }
            }
        }
        return combHead;
    }
}