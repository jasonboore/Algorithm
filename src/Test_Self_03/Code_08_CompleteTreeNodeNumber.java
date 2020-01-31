package Test_Self_03;

/**
 * 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 * @author jasonborn
 *
 */
public class Code_08_CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	public static int nodeNum(Node head) {
		if(head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	public static int bs(Node head, int level, int height) {
		if(level == height) {
			return 1;
		}
		if(mostLeftLevel(head.right, level + 1) == height) {
			return (1 << (height - level)) + bs(head.right, level + 1, height);
		}else {
			return (1 << (height - level -1)) + bs(head.left, level + 1, height);
		}
	}
	public static int mostLeftLevel(Node head, int level) {
		while(head != null) {
			level++;
			head = head.left;
		}
		return level - 1;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}
}
