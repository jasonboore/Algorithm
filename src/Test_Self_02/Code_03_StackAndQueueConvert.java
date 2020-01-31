package Test_Self_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 用栈实现队列和用队列实现栈
 * @author jasonborn
 *
 */
public class Code_03_StackAndQueueConvert {
	
	public static class TwoStacksQueue{
		
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
		
		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		public void push(int num) {
			this.stackPush.push(num);
		}
		
		public int poll() {
			if(this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pour();
			return this.stackPop.pop();
		}
		
		public int peek() {
			
			if(this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pour();
			return this.stackPop.peek();
			
		}
		public void pour() {
			if(!this.stackPop.isEmpty()) {
				return;
			}
			
			while(!this.stackPush.isEmpty()) {
				this.stackPop.push(this.stackPush.pop());
			}
		}
	}
	
	public static class TwoQueuesStack {
		
		private Queue<Integer> queue;
		private Queue<Integer> help;
		
		public TwoQueuesStack() {
			queue = new LinkedList<>();
			help = new LinkedList<>();
		}
		
		public void push(int num) {
			this.queue.add(num);
		}
		
		public int pop() {
			
			if(this.queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			
			while(queue.size() != 1) {
				this.help.add(this.queue.poll());
			}
			
			int res = queue.poll();
			swap();
			return res;
		}
		
		public int peek() {
			
			if(this.queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			
			while(queue.size() != 1) {
				this.help.add(this.queue.poll());
			}
			
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}
		
		
		public  void swap() {
			Queue<Integer> temp = this.queue;
			this.queue = this.help;
			this.help = temp;
		}
	}
}
