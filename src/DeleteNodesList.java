import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class ListNode{
    ListNode next;
    int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}

public class DeleteNodesList {


    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2};
        ListNode head = createList(arr);
        printList(head);
        System.out.println();
        int[] nums = {1};
        ListNode res =  modifiedList(nums, head);
        printList(res);
    }

    private static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ListNode temp = head, prev = head;
        while (temp != null) {
            if(set.contains(temp.val))
            {
                if(temp == head) {
                    head = head.next;
                    temp = head;
                    prev = temp;
                }else {
                    prev.next = temp.next;
                    temp = prev.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

            return head;
    }

    private static ListNode deleteNode(ListNode nodeToDelete, ListNode head) {
        ListNode curr = head;
        if(nodeToDelete == curr) {
            head = head.next;
            curr.next = null;
            return head;
        }
        ListNode Next = curr.next;
        while(Next != null) {
            if(Next == nodeToDelete) {
                curr.next = Next.next;
                Next.next = null;
                break;
            }
            curr = curr.next;
            Next = curr.next;
        }
        return head;
    }

    private static ListNode findNode(ListNode head, int num) {
        while(head != null) {
                if(head.val == num) {
                    return head;
                }
                head = head.next;
            }
            return null;
    }


    private static void printList(ListNode curr) {
        while(curr != null) {
            System.out.print(" " + curr.val);
            curr = curr.next;
        }
    }

    private static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        int i =1;
        while(i< arr.length) {
            ListNode node = new ListNode(arr[i]);
            curr.next = node;
            curr = node;
            i++;
        }
        return head;
    }
}
