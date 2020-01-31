package Test_Self_06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * һ������г����룬
 * ����Ҫ���Ѻͳ�����ֵһ����ͭ��ġ�
 * ���� ����Ϊ20�� �����������гɳ��ȶ������룬
 * ��Ҫ����20��ͭ �塣һȺ������������� ������ô����ʡͭ�壿
 * ����,��������{10,20,30}������һ�������ˣ������������Ϊ 10+20+30=60.
 * ����Ҫ�ֳ�10,20,30�������֡� 
 * ����� �Ȱѳ� ��60�Ľ����ֳ�10��50��
 * ����60 �ٰѳ���50�Ľ����ֳ�20��30�� ����50 һ������110ͭ�塣
 * ��������� �Ȱѳ���60�Ľ����ֳ�30��30��
 * ����60 �ٰѳ���30 �����ֳ�10��20������30 һ������90ͭ�塣
 * ����һ�����飬���طָ����С���ۡ�
 * @author jasonborn
 *
 */

public class Code_02_Less_Money {
	public static int lessMoney(int[] arr) {
		PriorityQueue<Integer> moneyHeap = new PriorityQueue<>();
		for(int temp : arr) {
			moneyHeap.add(temp);
		}
		int sum = 0;
		int cur = 0;
		while(moneyHeap.size() > 1) {
			cur = moneyHeap.poll() + moneyHeap.poll();
			sum += cur;
			moneyHeap.add(cur);
		}
		return sum;
	}
	public static class MinheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2; // < 0  o1 < o2  负数
		}

	}

	public static class MaxheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1; // <   o2 < o1
		}

	}
	public static void main(String[] args) {
		// solution
		int[] arr = { 6, 7, 8, 9 };
		System.out.println(lessMoney(arr));

		int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
		System.out.println(lessMoney(arrForHeap));

		// min heap
		PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ1.add(arrForHeap[i]);
		}
		while (!minQ1.isEmpty()) {
			System.out.print(minQ1.poll() + " ");
		}
		System.out.println();

		// min heap use Comparator
		PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ2.add(arrForHeap[i]);
		}
		while (!minQ2.isEmpty()) {
			System.out.print(minQ2.poll() + " ");
		}
		System.out.println();

		// max heap use Comparator
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			maxQ.add(arrForHeap[i]);
		}
		while (!maxQ.isEmpty()) {
			System.out.print(maxQ.poll() + " ");
		}

	}
}
