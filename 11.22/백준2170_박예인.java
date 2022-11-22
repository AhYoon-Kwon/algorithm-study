import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][2];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
    //정렬
		Arrays.sort(map, (o1, o2) -> {
			if (o1[0] == o2[0])
				return Integer.compare(o1[1], o2[1]);
			else
				return Integer.compare(o1[0], o2[0]);
		})
		// 초기화
		int sum =0;
		int start = map[0][0];
		int end = map[0][1];
    
		for (int i=1; i<map.length; i++) {
			int a = map[i][0];
			int b = map[i][1];
      //포함될 경우
			if (a >= start && b <= end) continue;
      //큰 쪽이 삐져나갈 경우
			else if (a >= start && a <= end && b>end) end = b;
			//포함되지 않을 경우
			else if (a > end) {
				sum += end-start;
				start = a;
				end = b;
			}
		}
    //마지막 값까지 더해서 계산
		System.out.println(sum + end-start);
	}
}
