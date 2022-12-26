import java.util.*;

class Solution {
    static char [][] map;
    static boolean [][] check;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i=0; i<m; i++)
            map[i]=board[i].toCharArray();
        
        int answer = 0;
        while(true){
            check = new boolean[m][n];
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j]==0) continue;
                    checkBlock(i, j);
                }
            }

             int cnt = countBlock(m, n);
             if(cnt==0) break;
             answer+=cnt;
            
             moveBlock(m, n);
        }
        
        return answer;
    }
    //4*4 체크하기
    static int [] dx = {1, 1, 0};
    static int [] dy = {0, 1, 1};
    static void checkBlock(int x, int y){
        char standard = map[x][y];
        for(int idx=0; idx<3; idx++){
            int i = x+dx[idx];
            int j = y+dy[idx];
            if(map[i][j]==0||map[i][j]!=standard) return;
        }
        for(int idx=0; idx<3; idx++){
            int i = x+dx[idx];
            int j = y+dy[idx];
            check[i][j]=true;
        }
        check[x][y]=true;
    }
    //해당 턴에서 없어지는 블록 갯수 카운트
    static int countBlock(int m, int n){
        int cnt=0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(check[i][j]) {
                    cnt++;
                    map[i][j]=0;
                }
        return cnt;
    }
    //블록 빈공간으로 이동
    static void moveBlock(int m, int n){
        for(int j=0; j<n; j++)
            for(int i=m-1; i>=0; i--){
               if(map[i][j]==0) {
                   int idx = i;
                   while(true){
                       if(idx==-1) break;
                       if(map[idx][j]!=0){
                           map[i][j]=map[idx][j];
                           map[idx][j]=0;
                           break;
                       }
                       idx--;
                   }
               }
            }
    }
}
