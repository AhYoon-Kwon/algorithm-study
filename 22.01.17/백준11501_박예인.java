import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] list = new int[n];
			int max = Integer.MIN_VALUE;
			long sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = 0;
			while (st.hasMoreElements()) {
				list[idx++] = (Integer.parseInt(st.nextToken()));
			}
			for (int i=n-1; i>=0; i--) {
				if (max < list[i]) 
					max = list[i];
				if (max > list[i])
					sum += (max-list[i]);
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}
