import java.util.*;

public class 백준14888_김민지 {
	static boolean [] visit;
	static int [] num, operator, res;
	static int N, max, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		num = new int[N];
		for(int i=0; i<N; i++)
			num[i]=sc.nextInt();
		
		operator = new int [N-1];
		int k=0;
		for(int i=0; i<4; i++) {
			int x =sc.nextInt();
			for(int j=0; j<x; j++)
				operator[k++]=i;
		}
			
		max=Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		res= new int [N-1];
		visit = new boolean [N-1];
		arrange(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void arrange(int cnt) {
		if(cnt==N-1) {
			int sum=num[0];
			for(int i=0; i<N-1; i++) {
				int oper = res[i];
				switch(oper) {
				case 0:
					sum+=num[i+1];
					break;
				case 1:
					sum-=num[i+1];
					break;
				case 2:
					sum*=num[i+1];
					break;
				case 3:
					if(sum<0) {
						sum*=-1;
						sum/=num[i+1];
						sum*=-1;
					}else {
						sum/=num[i+1];
					}
					break;
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			res[cnt]=operator[i];
			arrange(cnt+1);
			visit[i]=false;
		}

	}
}
