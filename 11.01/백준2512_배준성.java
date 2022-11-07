import java.util.Arrays;
import java.util.Scanner;

public class 백준2512 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arg = new int[n];
		
		for(int i = 0; i < n; i++) {
			arg[i] = sc.nextInt();
		}
		
		int money = sc.nextInt();
		
		Arrays.sort(arg);
		
		int ans = arg[n-1];
		
		for(int i = 0; i < n; i++) {
			if(arg[i] > money/(n-i)) {
				ans = money/(n-i);
				break;
			}
			money -= arg[i];
		}
		System.out.print(ans);
	}
}
