import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준2170_유동윤 {

	static public class line implements Comparable<line> {
		int st, ed;

		public line(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}

		@Override
		public int compareTo(line o) {
			return this.st - o.st;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		//앞자리가 큰거 순으로 pq에 넣는다.
		PriorityQueue<line> pq = new PriorityQueue<>();
		for (int i = 0; i < a; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			pq.add(new line(st, ed));
		}
		
		int start = pq.peek().st;
		int end = pq.peek().ed;
		int res = end - start;
		while (!pq.isEmpty()) {
			line e = pq.poll();
			//안에 속하는 선이면 넘어가
			if(e.ed <= end) continue;
			//연장되는 선이면 그만큼 res에 추가
			if(e.st < end)
				res += e.ed - end;
			//끊겨있으면 새롭게 이어
			else
				res += e.ed - e.st;
			start = e.st;
			end = e.ed;
		}
		System.out.println(res);
	}
}
