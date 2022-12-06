import java.util.*;
import java.io.*;

public class 백준1337 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0){
            bw.write("5");
        }else{
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            
            int[] dif = new int[N-1];
            for(int i = 0; i < N-1; i++){
                dif[i] = arr[i+1] - arr[i]; 
            }
            
            int cnt;
            int sum;
            int max = 1;
            
            all:for(int i = 0; i < N-1; i++) {
                sum = 0;
				cnt = 1;
				int j = i;
				while(j < N-1) {				
					sum+=dif[j];
					if(sum > 4) {
						break;
					}
					cnt++;
					j++;
				}
				if(max < cnt) {
					max = cnt;
				}
			}
            if(max > 5) {
				max = 5;
			}
			bw.write((5-max) + "");
        }
        bw.close();
    }
}
