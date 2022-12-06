import java.util.*;
import java.io.*;

public class 백준1058 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[N][N];
        
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }
        
        int max = 0;
        int sum;
        
        for(int i = 0; i < N; i++){
            sum = 0;
            int[] fr = new int[N];
            
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 'Y'){
                    fr[j] += 2;
                    for(int k = 0; k < N; k++){
                        if(arr[j][k] == 'Y'&& i != k){
                        	fr[k]++;
                        }
                    }
                }
            }
            
            for(int j = 0; j < N; j++){
                if(fr[j] >= 1){
                    sum++;
                }
            }
            
            max = Math.max(max, sum);
        }
        
        bw.write(max + "");
        bw.close();
    }
}
