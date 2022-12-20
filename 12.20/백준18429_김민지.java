import java.util.*;


public class Main {
	static boolean [] visit;
	static int [] amount, tmp;
	static int N, K, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //n일동안
		K = sc.nextInt(); // 감소량
		amount = new int [N];
		tmp = new int [N];
		for(int i=0; i<N; i++)
			amount[i]=sc.nextInt();
		
		visit = new boolean[N];
		res=0;
		check(0);
		
		System.out.print(res);
	}
	public static void check(int cnt) {
		if(cnt==N) {
			int sum=-K;
			for(int i=0; i<N; i++) {
				sum+=tmp[i];
				if(sum<0) {
					return;
				}
				sum-=K;
			}
			res++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			tmp[cnt]=amount[i];
			check(cnt+1);
			visit[i]=false;

		}
	}
}
