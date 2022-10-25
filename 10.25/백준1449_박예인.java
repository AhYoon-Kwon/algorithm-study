/*반례 다 맞는데 ... 답이 틀립니다
반례 찾아요... */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int cnt = 0;
		//물 새는 곳
		int[] pipe = new int[n];
		for (int i =0; i<n; i++) {
			pipe[i] = sc.nextInt();
		}
		//정렬
		Arrays.sort(pipe);
//		System.out.println(Arrays.toString(pipe));
		int min = pipe[0];
		for (int i =1; i<n; i++) {
			if (pipe[i]-min <=l+1) {
//				System.out.println("pipe - min");
				continue;
			}
			else
			{
//				System.out.println(pipe[i-1]-min);
				
				cnt += ((pipe[i-1]-min) / l) +1;
				min = pipe[i];
			}
		}

		cnt += ((pipe[n-1]-min) / l) +1;
		
		if (n == 2) {
			if (pipe[1]-pipe[0] >= l)
				{cnt = 2;}else cnt = 1;
		}

		System.out.println(cnt);
	}
}
