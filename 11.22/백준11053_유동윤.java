import java.util.Scanner;

public class 백준11053_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		int[] cnt = new int[1001]; //1 ≤ Ai ≤ 1,000
		int res = 0;
		//자기까지 오면서 가장 길게 만들 수 있는걸 센다.
		for(int i=0;i<a; i++) {
			int num = sc.nextInt();
			int min = 0;
			for(int j=1; j<num;j++) {
				if(cnt[j]>min)
					min = cnt[j];
			}
			cnt[num] = min +1;
			//새로 들어간게 기존것보다 크면 최신화
			if(cnt[num]>res)
				res = cnt[num];
		}
		System.out.println(res);
	}
}