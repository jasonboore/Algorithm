package Test_Self_03;
/**
 * 判断一棵二叉树是否是平衡二叉树
 * @author jasonborn
 *
 */
public class Code_06_IsBalancedTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class ReturnData {
		public boolean isB;
		public int height;
		
		public ReturnData(boolean isB, int height) {
			this.isB = isB;
			this.height = height;
		}
	}
	public static ReturnData process(Node head) {
		if(head == null) {
			return new ReturnData(true, 0);
		}
		ReturnData left = process(head.left);
		if(!left.isB) {
			return new ReturnData(false, 0);
		}
		ReturnData right = process(head.right);
		if(!right.isB) {
			return new ReturnData(false, 0);
		}
		if(Math.abs(left.height - right.height) > 1) {
			return new ReturnData(false, 0);		
		}
		return new ReturnData(true, Math.max(left.height, right.height) + 1);
	}
	
	public static boolean isBalance(Node head) {
		return process(head).isB;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.left = new Node(8);
		//head.left.right.left.left = new Node(9);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));
	}

}
