import java.util.Scanner;

public class 백준2302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr;
		
		if(N<2) {
			arr = new int[3];			
		}
		else {			
			arr = new int[N+1];
		}
		
//		DP문제
//		좌석이 연속일 떄 점화식을 구해보면
//		점화식은 DP[i] = DP[i-1] + DP[i-2]
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
//		vip가 중간에 끼면 서로 분리된다
		
		int ans = 1;
		int start = 0; //시작 좌석 번호
		
		for(int i = 0; i < M; i++) {
			int tmp = sc.nextInt(); //vip 좌석 번호
			ans *= arr[tmp - (start + 1)];
			start = tmp;
		}
		ans *= arr[N - start];
		
		System.out.print(ans);
	}
}
