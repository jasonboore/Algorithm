package Test_Self_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 一个数据流中，随时可以取得中位数
 * @author jasonborn
 *
 */
public class Code_04_MadianQuick {
	public static class MedianHolder {
		PriorityQueue<Integer> minHeapQueue = new PriorityQueue<>(new MinHeapComparator());
		PriorityQueue<Integer> maxHeapQueue = new PriorityQueue<>(new MaxHeapComparator());
		
		private void modifyTwoHeapsSize() {
			if(this.minHeapQueue.size() == maxHeapQueue.size() + 2) {
				this.maxHeapQueue.add(minHeapQueue.poll());
			}
			if(this.maxHeapQueue.size() == minHeapQueue.size() + 2) {
				this.minHeapQueue.add(maxHeapQueue.poll());
			}
		}
		public void addNumber(int num) {
			if(maxHeapQueue.isEmpty()) {
				maxHeapQueue.add(num);
				return;
			}
			if(!maxHeapQueue.isEmpty()) {
				if(maxHeapQueue.peek() >= num) {
					maxHeapQueue.add(num);
				}else {
					if(minHeapQueue.isEmpty()) {
						minHeapQueue.add(num);
						return;
					}
					if(minHeapQueue.peek() <= num) {
						minHeapQueue.add(num);
					}else {
						maxHeapQueue.add(num);
					}
						
					
				}
			}
			modifyTwoHeapsSize();
		}
		public Float getMedian() {
			int minSize = minHeapQueue.size();
			int maxSize = maxHeapQueue.size();
			if(minSize == 0 && maxSize == 0) {
				return null;
			}
			if(((minSize + maxSize) & 1) == 0) {
				return (minHeapQueue.peek() + maxHeapQueue.peek()) * 1.0f / 2;
			}else {
				return maxSize > minSize ? maxHeapQueue.peek() * 1.0f : minHeapQueue.peek() * 1.0f;
			}
			
		}
	}
	public static class MinHeapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO 自动生成的方法存根
		return o1 - o2;
	}
	
}
	public static class MaxHeapComparator implements Comparator<Integer> {
	
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO 自动生成的方法存根
				return o2 - o1;
			}
			
		}
	public static void main(String[] args) {
		MedianHolder medianHolder = new MedianHolder();
		int[] test = {1, 8, 9, 5, 4, 6, 2, 0, 3, 10, 2, 6, 8, 6, 5, 10};
		for(int num : test) {
			medianHolder.addNumber(num);
		}
		System.out.println(medianHolder.getMedian());
		Arrays.sort(test);
		for(int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		
	}
}
