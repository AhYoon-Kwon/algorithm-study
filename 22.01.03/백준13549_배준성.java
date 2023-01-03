import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] visited = new int[100001];
        visited[N] = 1;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        
        while(dq.size() > 0){
            int node = dq.remove();
            int doubleNode = node * 2;
            int plusNode = node + 1;
            int minusNode = node - 1;
            int value = visited[node];
            
            if(node == K){
                bw.write((visited[K] - 1) + "");
                bw.close();
            }
            
            if(doubleNode <= 100000 && visited[doubleNode] == 0){
                dq.addFirst(doubleNode);
                visited[doubleNode] = value;
            }
            
            if(plusNode <= 100000 && visited[plusNode] == 0){
                dq.addLast(plusNode);
                visited[plusNode] = value + 1;
            }
            
            if(minusNode >= 0 && visited[minusNode] == 0){
                dq.addLast(minusNode);
                visited[minusNode] = value + 1;
            }
        }      
    }
}
