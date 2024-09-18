package leetcodeDaily2024;

import com.OD.ListNode;

public class B2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode curr1 = l1;
        curr1.next = new ListNode(4);
        curr1 = curr1.next;
        curr1.next = new ListNode(3);
        curr1 = curr1.next;

        ListNode l2 = new ListNode(5);
        ListNode curr2 = l2;
        curr2.next = new ListNode(6);
        curr2 = curr2.next;
        curr2.next = new ListNode(4);
        curr2 = curr2.next;

        System.out.println(new B2().addTwoNumbers(l1,l2));

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1 != null || l2 !=null) {
            int n1 = l1 !=null ? l1.val : 0;
            int n2 = l2 !=null ? l2.val : 0;
            int sum = n1+n2+carry;
            if(head==null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
