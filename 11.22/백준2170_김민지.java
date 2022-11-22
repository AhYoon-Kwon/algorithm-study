import java.io.*;
import java.util.*;

public class 백준2170_김민지 {
    public static class Node implements Comparable<Node>{
        private int x, y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) return o.y-this.y;
            return this.x-o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        Node [] node = new Node[tc];
        for(int i=0; i<tc; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[i]=new Node(x, y);
        }
        Arrays.sort(node);
        int length=0;
        int start=node[0].x;
        int end=node[0].y;
        for(int i=1; i<tc; i++){
            if(node[i].x>end){
                length += end-start;
                start=node[i].x;
                end=node[i].y;
            }else if(start<=node[i].x&&node[i].y<=end) {
                continue;
            }else{
                end=end>node[i].y?end:node[i].y;
            }
        }
        length += end-start;
        bw.write(Integer.toString(length));
        bw.flush();
        bw.close();
    }
}
