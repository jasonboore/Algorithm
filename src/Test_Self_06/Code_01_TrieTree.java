package Test_Self_06;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 前缀树
 * 例子： 一个字符串类型的数组arr1，另一个字符串类型的数组arr2。
 * arr2中有哪些字符，是arr1中出现的？请打印
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？请 打印
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？请打印 arr2中出现次数最大的前缀。
 * @author jasonborn
 *
 */
public class Code_01_TrieTree {
	public static class TrieNode {
		public int path;
		public int end;
		HashMap<Character, TrieNode> next;
		
		public TrieNode() {
			path = 0;
			end = 0;
			next = new HashMap<>();
		}
	}
	public static class Trie {
		TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word)  {
			if(word == null) {
				return;
			}
			char[] chars = word.toCharArray();
			TrieNode node = root;
			for(int i = 0; i < chars.length; i++) {
				if(!node.next.containsKey(chars[i])) {
					TrieNode trieNode = new TrieNode();
					node.next.put(chars[i], trieNode);
				}
				node = node.next.get(chars[i]);
				node.path++;
			}
			node.end++;
		}
		public int search(String word) {
			if(word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			for(int i = 0; i < chs.length; i++) {
				if(!node.next.containsKey(chs[i])) {
					return 0;
				}
				node = node.next.get(chs[i]);
			}
			return node.end;
		}
		public void delete(String word) {
			if(search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				for(int i = 0; i < chs.length; i++) {
					if(--node.next.get(chs[i]).path == 0) {
						node.next.remove(chs[i]);
						return;
					}
					node = node.next.get(chs[i]);
				}
				node.end--;
			}
		}
		public int prefixNumber(String pre) {
			if(pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			for(int i = 0; i < chs.length; i++) {
				if(!node.next.containsKey(chs[i])) {
					return 0;
				}
				node = node.next.get(chs[i]);
			}
			return node.path;
		}
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
//		System.out.println(trie.search("zhang"));
//		trie.insert("zhang");
//		System.out.println(trie.search("zhang"));
//		trie.delete("zhang");
//		System.out.println(trie.search("zhang"));
//		trie.insert("zhang");
//		trie.insert("zhang");
//		trie.delete("zhang");
//		System.out.println(trie.search("zhang"));
//		trie.delete("zhang");
//		System.out.println(trie.search("zhang"));
//		trie.insert("zhanga");
//		trie.insert("zhangac");
//		trie.insert("zhangab");
//		trie.insert("zhangb");
//		trie.delete("zhangab");
//		System.out.println(trie.search("zhanga"));
//		System.out.println(trie.prefixNumber("zhang"));
		
		String[] arr1 = {"zhang", "da", "feng", "zui", "shuai", "zhanga", "zhang", "zhangac" , "daa", "dab", "dac"};
		String[] arr2 = {"zhang", "da", "feng", "zhangac", "da", "zhang"};
		for(int i = 0; i < arr1.length; i++) {
			trie.insert(arr1[i]);
		}
		for(int i = 0; i < arr2.length; i++) {
			int times = trie.search(arr2[i]);
			if( times!= 0) {
				System.out.println(arr2[i]);
			}
		}
		System.out.println("===========");
		int max = 0;
		
		ArrayList<String> list = new ArrayList<>(); 
		for(int i = 0; i < arr2.length; i++) {
			int times = trie.prefixNumber(arr2[i]);
			if(times!= 0) {
				if(max < times) {
					list.clear();
					list.add(arr2[i]);
					max = max < times ? times : max;
				}else if(max == times) {
					boolean isIn = false;
					for(String str : list) {
						if(arr2[i].equals(str)) {
							isIn = true;
							break;			
							}
					}
					if(!isIn) {
						list.add(arr2[i]);
					}	
				}
				System.out.println(arr2[i]);
			}
		}
		System.out.println("===========");
		for(String str : list) {
			System.out.println(str);
		}
		System.out.println(max);
		System.out.println("===========");
	}
}
