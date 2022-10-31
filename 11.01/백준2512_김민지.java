import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//조건 입력
		int N = sc.nextInt();
		int [] budgets = new int [N];
		int sum = 0;
		int max=0;
		for(int i=0; i<N; i++) {
			budgets[i]=sc.nextInt();
			sum+=budgets[i];
			max=max>budgets[i]?max:budgets[i];
		}
		int M = sc.nextInt();
		//요청액의 합이 총액보다 크면 정수 상한액 필요
		if(sum>M) {
			//기존 최댓값에서 --하면서 요청액의 합이 예산 총액의 합보다 작을 때까지 확인
			while(--max>0) {
				sum=0;
				for(int i=0; i<N; i++) {
					int x =budgets[i]>max?max:budgets[i];
					sum+=x;
				}
				if(sum<=M) break;
			}
		}
		System.out.println(max);
	}
}
