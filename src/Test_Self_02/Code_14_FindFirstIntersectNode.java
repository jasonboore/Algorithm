package Test_Self_02;

/**
 * 在本题中，单链表可能有环，也可能无环。
 * 给定两个 单链表的头节点 head1和head2，
 * 这两个链表可能相交，也可能 不相交。
 * 请实现一个函数， 如果两个链表相交，请返回相交的 第一个节点；
 * 如果不相交，返回null 即可。 
 * 要求：如果链表1 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外 空间复杂度请达到O(1)。
 * @author jasonborn
 *
 */

public class Code_14_FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		
		Node Loop1 = getLoop(head1);
		Node Loop2 = getLoop(head2);
		if(Loop1 == null && Loop2 == null) {
			return noLoop(head1, head2);
		}else if(Loop1 != null && Loop2 != null) {
			return bothLoop(head1, Loop1, head2, Loop2);
		}else {
			return null;
		}
		
		
	}

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2) {
			 cur1 = head1;
			 cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return cur1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static Node noLoop(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while(n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static Node getLoop(Node head) {
		if(head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;
		Node n2 = head.next.next;
		while(n1 != n2) {
			if(n2.next == null || n2.next.next == null) {
				return null;
				
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n2 = head;
		while(n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		Node res = getIntersectNode(head1, head2);
		System.out.println(res == null ? null : res.value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);
		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
