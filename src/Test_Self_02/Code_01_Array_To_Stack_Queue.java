package Test_Self_02;
/**
 * 用数组实现固定大小的栈和队列
 * @author jasonborn
 *
 */
public class Code_01_Array_To_Stack_Queue {
	
	public static class ArrayStack {
		private Integer[] arr;
		private Integer size;
		
		public ArrayStack(int initSize) {
			
			if(initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			
			arr = new Integer[initSize];
			size = 0;
		}
		
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			
			return arr[size - 1];
		}
		
		public void push(int obj) {
			if(size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[size++] = obj;
		} 
		public Integer pop() {
			if(size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}

			return arr[--size];
		}
	}
	
	public static class ArrayQueue{
		
		private Integer[] arr;
		private Integer start;
		private Integer end;
		private Integer size;
		
		public ArrayQueue(int initSize) {
			if(initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			
			arr = new Integer[initSize];
			size = 0;
			start = 0;
			end = 0;
		}
		
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			
			return arr[start];
		}
		
		public void push(int obj) {
			if(size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			
			size++;
			arr[end] = obj;
			end = end == arr.length - 1 ? 0 : end + 1;
		}
		
		public Integer poll() {
			if(size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			
			size--;
			int res = arr[start];
			start = start == arr.length - 1 ? 0 : start + 1;
			return res;
		}
	}
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		Code_01_Array_To_Stack_Queue.ArrayStack arrayStack = new ArrayStack(7);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			arrayStack.push(arr[i]);
		}
		
		System.out.println("");
		int arraySize = arrayStack.size;
		for(int i = 0; i < arraySize; i++) {
			System.out.print(arrayStack.pop()+ " ");
		}
		
		System.out.println("");
		
		Code_01_Array_To_Stack_Queue.ArrayQueue arrayQueue = new ArrayQueue(7);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			arrayQueue.push(arr[i]);
		}
		
		System.out.println("");
		int arraySize1 = arrayQueue.size;
		for(int i = 0; i < arraySize1; i++) {
			System.out.print(arrayQueue.poll()+ " ");
		}
	}
}
