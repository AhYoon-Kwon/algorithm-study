import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[n];
		int[] isEaten = new int[d+1];
		int max = 0;
		
		for (int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		//초밥 종류
		int cnt = 0;
		
		for (int i=0; i<k; i++) {
			if (isEaten[sushi[i]] == 0)
				cnt++;
			isEaten[sushi[i]]++;
		}
		
		for (int i=1; i<n; i++) {
			// 갯수 체크
			if (cnt == Math.max(max, cnt)) {
				if (isEaten[c] == 0)
					max = cnt+1;
				else
					max = cnt;
			}
			
			//맨앞초밥빼고맨뒤초밥넣기
			int end = (i+k-1)% n;
			if (isEaten[sushi[end]] == 0)
				cnt++;
			isEaten[sushi[end]]++;
			
			isEaten[sushi[i-1]]--;
			if (isEaten[sushi[i-1]] == 0)
				cnt--;
		}
		System.out.println(max);
	}
}
