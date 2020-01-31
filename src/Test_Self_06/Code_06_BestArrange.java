package Test_Self_06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，
 * 会议室不能同时容纳两个项目 的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面 是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会 议室进行 的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 * @author jasonborn
 *
 */
public class Code_06_BestArrange {
	public static class Meeting {
		public int start;
		public int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static class endComparetor implements Comparator<Meeting> {

		@Override
		public int compare(Meeting o1, Meeting o2) {
			// TODO 自动生成的方法存根
			return o1.end - o2.end;
		}
		
	}
	public static int bestArrange(Meeting[] meetings, int start) {
		Arrays.sort(meetings, new endComparetor());
		int result = 0;
		for(int i = 0; i < meetings.length; i++) {
			if(start <= meetings[i].start) {
				result++;
				start = meetings[i].end;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		Meeting[] meetings = {new Meeting(0, 3),
							  new Meeting(1, 2),
							  new Meeting(4, 6),
							  new Meeting(10, 12),
							  new Meeting(7, 9)} ;
		
		System.out.print(bestArrange(meetings, 0));
	}
}
