import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for(int n = 0; n < N; n++){       
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++){
                arr[n][i] = Integer.parseInt(st.nextToken());
            }
            
        }
//         start 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        int start = arr[0][0];
        int end = arr[0][1];
        int sum = 0;
//         end와 다음 start를 비교해서 연결되지 않으면 새롭게 시작
        for(int i = 1; i < N; i++){
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];
            
            if(nextStart > end){
                sum += end - start;
                start = nextStart;
                end = nextEnd;
            }else if(end < nextEnd){
                end = nextEnd;
            }
        }
        sum+= end - start;
        
        System.out.print(sum);
    }
}
