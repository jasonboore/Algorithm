package Test_Self_06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * һЩ��ĿҪռ��һ��������������
 * �����Ҳ���ͬʱ����������Ŀ ��������
 * ����ÿһ����Ŀ��ʼ��ʱ��ͽ�����ʱ��(����һ�����飬���� ��һ�����������Ŀ)��
 * ���������������ճ̣�Ҫ��� ���ҽ��� �������ĳ�����ࡣ
 * ������������������Ρ�
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
			// TODO �Զ����ɵķ������
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
