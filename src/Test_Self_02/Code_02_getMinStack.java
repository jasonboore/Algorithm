package Test_Self_02;

import java.util.Stack;


/**
 * 实现一个特殊的栈，在实现栈的基本功能上，再实现返回栈中最小元素的操作
 * @author jasonborn
 *
 */
public class Code_02_getMinStack {
	public static class MyStack1{
		
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		
		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}
		
		public void push(int num) {
			if(this.stackMin.isEmpty()) {
				this.stackMin.push(num);
			}else if(num <= this.getMin()) {
				this.stackMin.push(num);
			}
			
			this.stackData.push(num);
		}
		
		public int pop() {
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			
			int value = this.stackData.peek();
			if(value == this.getMin()) {
				this.stackMin.pop();
			}
			return value;
		}
		
		public int getMin() {
			
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}
	
	public static class MyStack2 {
		
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public  MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}
		
		public void push(int num) {
			if(this.stackMin.isEmpty()) {
				this.stackMin.push(num);
			}else if(num < this.getMin()) {
				this.stackMin.push(num);
			}else {
				this.stackMin.push(this.getMin());
			}
			
			this.stackData.push(num);
		}
		
		public int pop() {
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			
			this.stackMin.pop();
			return this.stackData.pop();
		}
		
		public int getMin() {
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			
			return this.stackMin.peek();
		}
		
	}
	
	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(5);
		System.out.println(stack1.getMin());
		stack1.push(2);
		System.out.println(stack1.getMin());
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(5);
		System.out.println(stack1.getMin());
		stack1.push(2);
		System.out.println(stack1.getMin());
		stack1.push(3);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

		System.out.println("=============");
		
		MyStack2 stack2 = new MyStack2();
		stack2.push(5);
		System.out.println(stack2.getMin());
		stack2.push(2);
		System.out.println(stack2.getMin());
		stack2.push(3);
		System.out.println(stack2.getMin());
		stack2.push(4);
		System.out.println(stack2.getMin());
		stack2.push(5);
		System.out.println(stack2.getMin());
		stack2.push(2);
		System.out.println(stack2.getMin());
		stack2.push(3);
		System.out.println(stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getMin());
}
}
