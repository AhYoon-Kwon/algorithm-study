//푸는중


import java.util.*;

class Solution {
    static List<Integer> list;
    static int idx, R, C;
    static int [][] box;
    public static class Node{
        int x,  y;
        Node(int x, int y ){
            this.x=x;
            this.y=y;
        }
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        R=rows;
        C=columns;
        box = new int [rows][columns];
        int x=1;
        for(int i=0;i<R; i++)
            for(int j=0; j<C; j++)
                box[i][j]=x++;
        
        list = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            answer[i]=
                circulate(new Node(queries[i][0],queries[i][1]),
                          new Node(queries[i][2],queries[i][3]));
        }
        return answer;
    }
    public static int [] dx ={ 0, 1, 0, -1};
    public static int [] dy ={1, 0, -1, 0};

    public static int circulate(Node right, Node left ){
        int min=Integer.MAX_VALUE;

        idx =0;
        int x = right.x;
        int y = right.y;
        int tmp = box[x][y];
        
        while(idx<4){       
            min = Math.min(min, tmp);
           int nx = right.x+dx[idx];
           int ny = right.y+dy[idx]; 
            int next = box[nx][ny];
            box[nx][ny]=tmp;
            tmp=next;
            isOut(right, left, nx, ny);
        }
        return min;
    }
    public static void isOut(Node right, Node left, int x, int y){
        if(x<0||y<0||x>=R||x>=C|x<right.x||x>left.x||y<right.y||y>left.y)
            idx++;
    }
}
