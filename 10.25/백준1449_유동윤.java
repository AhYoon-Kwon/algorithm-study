import java.util.Arrays;
import java.util.Scanner;

// 0.5단위로 끊어서 2000칸 만들고
// 구멍이 뚫려있으면 true로 바꿔줌
// 2000칸 하나씩 보면서 뚫린데있으면 한칸전 부터 테이프로 막아줌

public class 백준1449_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //구멍 수
		int m = sc.nextInt(); //테이프 길이
		boolean[] hole = new boolean[2003]; 
		for(int i=0; i<n; i++) {
			hole[sc.nextInt()*2] = true;
		}
		
		int cnt = 0;
		for(int i=0; i<2003; i++) {
			if(hole[i]) {
				cnt++;
				for(int j=-1; j<2*m; j++) {
					if(i+j>=0 && i+j<2003)
					hole[i+j]=false;
				}
			}
		}
		System.out.println(cnt);
	}
}
