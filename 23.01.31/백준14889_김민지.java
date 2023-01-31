import java.util.Scanner;

public class Main {
	static int n, min;
	static int [] start, link;
	static int [][] cap;
	static boolean [] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력
		n = sc.nextInt();
		cap = new int [n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				cap[i][j]=sc.nextInt();
		//조합: n명 중 n/2명 고르기
		start = new int[n/2];
		link = new int [n/2];
		sel = new boolean[n];
		min=Integer.MAX_VALUE;
		divide(0, 0);
		//출력
		System.out.println(min);
		
	}
	public static void divide(int idx, int cnt) {
		if(cnt==n/2) {//
			int a=0; int b=0;
			//팀나누기
			for(int i=0; i<n; i++) {
				if(sel[i]) start[a++]=i;
				else link[b++]=i;
			}
			//팀별 능력치 차이 구하기
			int sum=0;
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<n/2; j++) {
					sum+=cap[start[i]][start[j]];
					sum-=cap[link[i]][link[j]];
				}
			}
			//최솟값비교하기
			min=min<Math.abs(sum)?min:Math.abs(sum);
			return;
		}
		if(idx==n) return;
		
		sel[idx]=true;
		divide(idx+1, cnt+1);
		sel[idx]=false;
		divide(idx+1,cnt);
		
	}

}
