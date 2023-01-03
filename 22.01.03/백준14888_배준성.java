import java.util.Scanner;

public class Main {

	public static int num;
	public static int[] arr;
	public static int[] opr = new int[4];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			opr[i] = sc.nextInt();
		}

		dfs(arr[0], 1);

		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int ans, int idx) {
		if (idx == num) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opr[i] != 0) {
				opr[i]--;
				int res=0;

				if (i == 0)
					res = ans + arr[idx];
				else if (i == 1)
					res = ans - arr[idx];
				else if (i == 2)
					res = ans * arr[idx];
				else if (i == 3)
					res = ans / arr[idx];

				dfs(res, idx+1);
				opr[i]++;
			}

		}

	}
}
