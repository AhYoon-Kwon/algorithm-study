import java.util.Arrays;
import java.util.Scanner;

// 서류합격 순서로 나열한다.
// 자기보다 서류합격이 높은사람만 보면서
// 면접성적이 자기보다 높으면 체크한다.
public class 백준1946_유동윤 {

	static class grade implements Comparable<grade> {
		int a, b;

		public grade(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(grade o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			grade[] arr = new grade[n];
			for (int j = 0; j < n; j++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				arr[j] = new grade(n1, n2);
			}
			Arrays.sort(arr);
			int min = 1000000;
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j].b < min) {
					cnt++;
					min = arr[j].b;
				}
			}
			System.out.println(cnt);
		}

	}
}
