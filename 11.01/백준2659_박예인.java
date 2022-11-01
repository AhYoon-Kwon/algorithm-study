import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i =0; i<4;i++) {
			arr[i] = sc.nextInt();		
		}
		
		

		int target1 = arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];
		int target2 = arr[1]*1000+arr[2]*100+arr[3]*10+arr[0];
		int target3 = arr[2]*1000+arr[3]*100+arr[0]*10+arr[1];
		int target4 = arr[3]*1000+arr[0]*100+arr[1]*10+arr[2];
		int min = Math.min(Math.min(target1, target2), Math.min(target3, target4));
		System.out.println(clockNum(min));
		sc.close();
	}
	
	public static int clockNum(int A) {
		int cnt = 0;
		int num = 1111;
		while (num < A) {
			cnt++;
			num++;
			
			while(true) {
				if (num/100%10==0 || num/10 % 10==0 || num % 10 == 0)
					num++;
				else 
					break;
			}
			
		}
		return cnt;
		
		
	}
}
