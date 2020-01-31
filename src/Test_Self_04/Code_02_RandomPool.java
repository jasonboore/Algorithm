package Test_Self_04;

import java.util.HashMap;

public class Code_02_RandomPool<K> {
	public static class Pool<K> {
		HashMap<K, Integer> keyIndexMap;
		HashMap<Integer, K> IndexkeyMap;
		int size;
		
		public Pool() {
			keyIndexMap = new HashMap<>();
			IndexkeyMap = new HashMap<>();
			size = 0;
		}
		public void insert(K k) {
			if(!this.keyIndexMap.containsKey(k)) {
				this.keyIndexMap.put(k, size);
				this.IndexkeyMap.put(size++, k);
			}
		}
		public void delete(K k) {
			if(keyIndexMap.containsKey(k)) {
				int deleteIndex = this.keyIndexMap.get(k);
				int lastIndex = --this.size;
				K lastKey = this.IndexkeyMap.get(lastIndex);
				this.keyIndexMap.put(lastKey, deleteIndex);
				this.IndexkeyMap.put(deleteIndex, lastKey);
				this.keyIndexMap.remove(k);
				this.IndexkeyMap.remove(lastIndex);
			}
			
		}
		public K getRandom() {
			if (this.size == 0) {
				return null;
			}
			int Index = (int)(Math.random() * size);
			return this.IndexkeyMap.get(Index);
	}
	}
	public static void main(String[] args) {
		Pool<String> pool = new Pool<>();
		pool.insert("zhang");
		pool.insert("da");
		pool.insert("feng");
		pool.insert("shi");
		pool.insert("shuai");
		pool.insert("bi");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		
		System.out.println("=============");
		pool.delete("zhang");
		pool.delete("da");
		pool.delete("feng");
		pool.delete("shi");
		pool.delete("shuai");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
	}
		
	
}
