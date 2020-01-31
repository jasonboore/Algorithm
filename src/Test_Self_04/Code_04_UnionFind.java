package Test_Self_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 并查集结构
 * 功能：
 * 1.两个元素是否在同一集合
 * 2.A所在的集合一与B所在的集合合并在一起
 * @author jasonborn
 *
 */
public class Code_04_UnionFind {
	public static class Node {
		public int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	public static class UnionFindSet {
		HashMap<Node, Node> fatherMap;
		HashMap<Node, Integer> sizeMap;
		
		public UnionFindSet(List<Node> nodes) {
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			makeSet(nodes);
		}

		private void makeSet(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for(Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
			
		}
		
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if(father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) {
			if(a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if(aHead != bHead) {
				int aSize = sizeMap.get(aHead);
				int bSize = sizeMap.get(bHead);
				if(aSize <= bSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSize + bSize);
				}else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSize + bSize);
				}
			}
		}
	}
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		List<Node> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);
		list.add(seven);
		
		UnionFindSet unionFindSet = new UnionFindSet(list);
		boolean res = unionFindSet.isSameSet(one, two);
		System.out.println(res);
		res = unionFindSet.isSameSet(one, one);
		System.out.println(res);
		System.out.println("=============");
		
		unionFindSet.union(one, two);
		res = unionFindSet.isSameSet(one, two);
		System.out.println(res);
		res = unionFindSet.isSameSet(one, seven);
		System.out.println(res);
		System.out.println("=============");
		
		unionFindSet.union(two, three);
		res = unionFindSet.isSameSet(one, three);
		System.out.println(res);
		res = unionFindSet.isSameSet(one, seven);
		System.out.println(res);
		System.out.println("=============");
		
		unionFindSet.union(two, four);
		unionFindSet.union(five, six);
		unionFindSet.union(five, seven);
		res = unionFindSet.isSameSet(five, seven);
		System.out.println(res);
		res = unionFindSet.isSameSet(one, seven);
		System.out.println(res);
		System.out.println("=============");
		
		
	}
}
