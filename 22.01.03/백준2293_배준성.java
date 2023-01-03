import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int coin[] = new int[101];
        int dp[] = new int[10001];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 1;
        
        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j <= K; j++){
                dp[j] += dp[j - coin[i]];
            }
        }
        
        bw.write(dp[K] + "");
        bw.close();
    }
}
