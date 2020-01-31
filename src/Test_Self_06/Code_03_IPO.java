package Test_Self_06;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * ���룺 ����1����������costs 
 * ����2����������profits 
 * ����3�� ����k ����4��
 * ����m 
 * costs[i]��ʾi����Ŀ�Ļ���
 * profits[i]��ʾi����Ŀ�ڿ۳�����֮����������Ǯ(����)
 * k��ʾ�㲻�ܲ��С�ֻ�ܴ��е���� ��k����Ŀ 
 * m��ʾ���ʼ���ʽ� 
 * ˵������ÿ����һ����Ŀ�����ϻ�õ����棬����֧����ȥ���� һ�� ��Ŀ�� 
 * ����� ������õ����Ǯ����
 * @author jasonborn
 *
 */
public class Code_03_IPO {
	public static class Node {
		public int p;
		public int c;
		
		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO �Զ����ɵķ������
			return o1.c - o2.c;
		}
		
	}
	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO �Զ����ɵķ������
			return o2.p - o1.p;
		}
		
	}
	public static int findMaximizedCapital(int k, int W, int[] Profit, int[] Cost) {
		Node[] nodes = new Node[Profit.length];
		for(int i = 0; i < Profit.length; i++) {
			nodes[i] = new Node(Profit[i], Cost[i]);
		}
		PriorityQueue<Node> minCostQueue = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(new MaxProfitComparator());
		
		for(Node node : nodes) {
			minCostQueue.add(node);
		}
		
		for(int i = 0; i < k; i++) {
			while(!minCostQueue.isEmpty() && minCostQueue.peek().c <= W) {
				maxProfitQueue.add(minCostQueue.poll());
			}
			if(maxProfitQueue.isEmpty()) {
				return W;
			}
			W += maxProfitQueue.poll().p;
		}
		return W;
	}
	
	public static void main(String[] args) {
		int[] cost = {5, 10 ,20, 25 ,30};
		int[] profit = {5, 8, 2, 5, 10};
		int res = findMaximizedCapital(5, 10, profit, cost);
		System.out.println(res);
	}
}
