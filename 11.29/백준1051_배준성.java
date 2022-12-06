import java.util.*;
import java.io.*;

public class 백준1051 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
                
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int num;
        if(N > M){
            num = M;
        }else {
            num = N;
        }
        
        all:for(int n = num; n > 0; n--){
            for(int i = 0; i < N - n + 1; i++){
                for(int j = 0; j < M - n + 1; j++){
                    int di = i + n - 1;
                    int dj = j + n - 1;
                        
                    int A = map[i][j];
                    int B = map[i][dj];
                    int C = map[di][j];
                    int D = map[di][dj];
                    
                    if(A == B && B == C && C == D){
                        bw.write(n*n + "");
                        bw.close();
                        break all;
                    }
                }
            }
        }
    }
}
