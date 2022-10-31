import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//연속된 좌석 개수에 따른 배치 가능한 경우의 수 배열 - 피보나치
		int [] cnt = new int [N+1];
		cnt[0]=1;
		cnt[1]=1;
		for(int i=2; i<=N; i++) {
			cnt[i]=cnt[i-1]+cnt[i-2];
		}
		//vip 석을 기준으로 전체좌석을 분할
		int M = sc.nextInt();
		int [] vip = new int [M];
		int pin=0;
		int pre =0;
		int ans = 1;
		//분할된 좌석의 길이 구하고 그에 맞는 배치가능 경우의 수 찾기
		for(int i=0; i<M; i++) {
			pin = sc.nextInt();
			ans*=cnt[pin-pre-1];
			pre = pin;
		}
		ans*=cnt[N-pre];
		System.out.println(ans);
	}
}
