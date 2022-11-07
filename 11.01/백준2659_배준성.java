import java.util.Arrays;
import java.util.Scanner;

public class 백준2659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = 0;

		for (int i = 0; i < 4; i++) {
			input = input * 10 + sc.nextInt();
		}
		
		int num = check(input);

		int clockNum = 1111;
		int nextNum = 1111;
		int idx = 1;

		while (clockNum < num) {
			
			nextNum = check(clockNum + 1);
			if(nextNum > clockNum) {
				idx++;
			}
			clockNum++;
		}
		
		System.out.print(idx);
	}

	public static int check(int num) {
		
		int[] arg = new int[4];
		
		for(int i = 3; i >= 0; i--) {
			arg[i] = num % 10;
			num /= 10;
		}

		int[] numbers = new int[4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int idx = i + j;
				if (idx >= 4)
					idx -= 4;
				numbers[i] = numbers[i] * 10 + arg[idx];
			}
		}

		Arrays.sort(numbers);
		
		return numbers[0];
	}
}
