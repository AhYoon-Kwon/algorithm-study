import java.util.Arrays;
import java.util.Scanner;

public class 백준1946_김민지 {
	static class Rank implements Comparable<Rank>{
		int essay, interview;

		public Rank(int essay, int interview) {
			super();
			this.essay = essay;
			this.interview =interview;
		}

		@Override
		public int compareTo(Rank o) {
			if(this.essay>o.essay) {
				return 1;
			}else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc =0; tc<TC; tc++) {
			int N = sc.nextInt();
			Rank[] rank = new Rank[N];
			for(int i=0; i<N; i++) {
				rank[i]=new Rank(sc.nextInt(), sc.nextInt());
			}
			int count = 1;
			Arrays.sort(rank);
			int standard=rank[0].interview;
			for(int i=1; i<N; i++) {
				if(rank[i].interview<standard) {
					count++;
					standard = rank[i].interview;
				}
			}
			System.out.println(count);
		}
	}
}