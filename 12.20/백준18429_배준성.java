import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준18429 {
	static int N;
	static int K;
	static int ans;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		visited = new boolean[N];
		
		check(0, 500);
		
		bw.write(ans + "");
        bw.close();
	}
	static void check(int depth, int sum) {
		if(depth == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if(sum + arr[i] - K >= 500) {
					check(depth+1, sum + arr[i] - K);
				}
				visited[i] = false;
			}
		}
	}
}
