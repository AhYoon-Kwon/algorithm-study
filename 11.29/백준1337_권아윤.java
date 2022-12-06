import java.util.Arrays;
import java.util.Scanner;

public class 백준1337_권아윤 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); //배열의 크기
		int num[] = new int[N]; //10억이 들어갈수 있어야함
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}
		
		Arrays.sort(num);
		//정렬 후 배열을 5개씩 잘라가면서 그 배열의 첫 숫자로 시작하는 임시 배열을 만든다.
		//그 임시배열과 5개씩 자른 배열이 동일한지 비교
		
		int temp[] = new int[5];
		int comp[] = new int[5];
		int min = 5;
		int ans = 0;

		if(num.length > 5) {
			for (int i = 0; i <= num.length-5; i++) {
				int idx = 0;
				int diff = 0;

				for (int j = i; j < i+5; j++) { //5개씩 자르기
					comp[idx] = num[j];
					idx++;
				}
				
				int add = comp[0];

				for (int j = 0; j < temp.length; j++) { //비교할 배열 만들기
					temp[j] = add++;
				}
				
				int count = 0;
				for (int j = 0; j < comp.length; j++) {
					for (int j2 = 0; j2 < temp.length; j2++) {
						if(comp[j] == temp[j2]) count++; //두개 배열이 동일하면 ++
					}
				}
				diff = 5-count; //동일하지 않은 배열 개수 세기
				
				if(diff == 0) { //전부 동일하다
					ans = 0;
					break;
				} else {
					if(diff < min) {
						min = diff;
						ans = min;
					}
				}
			}
			
		} else { //배열이 5개 이하일때
			for (int i = 0; i < num.length; i++) {
				int idx = 0;
				int diff = 0;
				
				int add = num[i];

				for (int j = 0; j < temp.length; j++) { //비교할 배열 만들기
					temp[j] = add++;
				}
				
				int count = 0;
				for (int j = 0; j < num.length; j++) {
					for (int j2 = 0; j2 < temp.length; j2++) {
						if(num[j] == temp[j2]) count++; //두개 배열이 동일하면 ++
					}
				}
				diff = 5-count;
				
				if(diff < min) {
					min = diff;
					ans = min;
				}
			}
		}
		
		
		System.out.println(ans);
		
		scan.close();
	}

}
