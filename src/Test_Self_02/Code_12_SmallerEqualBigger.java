package Test_Self_02;

/**
 * 给定一个数
 * 将一个链表中小于这个数的放在左边，等于放在中间，大于放在右边
 * @author jasonborn
 *
 */
public class Code_12_SmallerEqualBigger {
	public static class Node { 
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
	}
	
	public static Node listPartition1(Node head, int pivot) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		
		Node[] nodeArr = new Node[i];
		cur = head;
		
		for(i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		
		
		arrPartition(nodeArr, pivot);
		
		for(i = 1; i < nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i -1].next = null;
		return nodeArr[0];
	}
	public static void arrPartition(Node[] nodeArr, int pivot) {
		int index = 0;
		int small = -1;
		int big = nodeArr.length;
		while(index < big) {
			if(nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			}else if(nodeArr[index].value > pivot) {
				swap(nodeArr, --big, index);
			}else {
				index++;
			}
		}
	}
	private static void swap(Node[] nodeArr, int i, int j) {
		// TODO 自动生成的方法存根
		Node temp = nodeArr[i];
		nodeArr[i] = nodeArr[j];
		nodeArr[j] = temp;
	}
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		
		while(head != null) {
			next = head.next;
			head.next = null;
			
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot) {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = head;
				}
			}else {
				if(bH == null) {
					bH = head;
					bT = head;
				}else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		
		if(sT != null) {
			sT.next = eH;
			eT = eT != null ? eT : sT;
		}
		if(eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = listPartition1(head1, 5);
		//head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

}
