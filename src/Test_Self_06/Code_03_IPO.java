package Test_Self_06;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 输入： 参数1，正数数组costs 
 * 参数2，正数数组profits 
 * 参数3， 正数k 参数4，
 * 正数m 
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多 做k个项目 
 * m表示你初始的资金 
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下 一个 项目。 
 * 输出： 你最后获得的最大钱数。
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
			// TODO 自动生成的方法存根
			return o1.c - o2.c;
		}
		
	}
	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO 自动生成的方法存根
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
