package Test_Self_04;

import java.util.ArrayList;
import java.util.HashMap;

public class Code_01_HashMap {
	public static void main(String[] args) {
		HashMap<String , String> map = new HashMap<>();
		map.put("zhang", "23");
		System.out.println(map.containsKey("zhang"));
		System.out.println(map.containsKey("dafeng"));
		System.out.println("=========================");
		
		System.out.println(map.get("zhang"));
		System.out.println(map.get("chengyun"));
		System.out.println("=========================");
		
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");
		
		System.out.println(map.remove("zhang"));
		System.out.println(map.containsKey("zhang"));
		System.out.println(map.get("zhang"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");
		
		map.put("zhang", "22");
		System.out.println(map.get("zhang"));
		map.put("zhang", "21");
		System.out.println(map.get("zhang"));
		System.out.println("=========================");
		
		map.put("zhang", "21");
		map.put("da", "22");
		map.put("feng", "23");
		for(String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("=========================");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("=========================");
		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		map.put("J", "1");
		map.put("K", "2");
		
		for(java.util.Map.Entry<String, String> entry : map.entrySet() ) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("{"+"\""+ key + "\"," + "\"" + value + "\"}");
		}
		System.out.println("=========================");
		
		// you can not remove item in map when you use the iterator of map
//		for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
//			if(!entry.getValue().equals("1")) {
//				map.remove(entry.getKey());
//			}
//		}
		
		// if you want to remove items, collect them first, then remove them by
				// this way.
		
		ArrayList<String> removeList = new ArrayList<String>();
		for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
			if(!entry.getValue().equals("1")) {
				removeList.add(entry.getKey());
			}
		}
		
		for(String removeKey : removeList) {
			map.remove(removeKey);
		}
		for(java.util.Map.Entry<String, String> entry : map.entrySet() ) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("{"+"\""+ key + "\"," + "\"" + value + "\"}");
		}
		System.out.println("=========================");
		System.out.println("=========================");
		System.out.println("=========================");
		System.out.println("=========================");
		System.out.println("=========================");
		
		


	}
}
