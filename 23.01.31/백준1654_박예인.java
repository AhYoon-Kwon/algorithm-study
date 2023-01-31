import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int[] lan = new int[n];
		
		for (int i=0; i<n; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
		
		long start = 1;
		long end = max;
		
		while (start <= end) {
			long sum = 0;
			long mid = (start + end) / 2;
			for (int i=0; i<n; i++) {
				sum += (lan[i] / mid);
			}
			
			if (sum >= k) {
				start = mid + 1;
			}else
				end = mid - 1;
		}
		System.out.println(end);
	}
}
