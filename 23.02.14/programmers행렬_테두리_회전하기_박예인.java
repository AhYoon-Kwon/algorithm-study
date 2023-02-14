import java.util.*;

class Solution {
    static int[] dy = {1, 0, -1 ,0};
    static int[] dx = {0, 1, 0, -1};
    static Point a, b;
    static int r, c;
    public int[] solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        r = rows;
        c = columns;
        //입력받기
        int[][] map = new int [102][102];
        for (int i=1; i<=r; i++) {
            for (int j=1; j<=c; j++) {
                map[i][j] = (i - 1) * columns + j;
            }
        }
        
        //쿼리들
        for (int[] q : queries){
            // System.out.println("--------");
            int min = Integer.MAX_VALUE;
            a = new Point(q[0], q[1], map[q[0]][q[1]]);
            b = new Point(q[2], q[3], map[q[2]][q[3]]);
            Point tmp = new Point(a.x, a.y, a.value);
            // System.out.println(a.x+" "+a.y+" "+a.value);
            
            Queue<Point> queue = new LinkedList<>();
            queue.add(a);
            
            int cnt = 0;
            int pre = a.value;
            
            while (!queue.isEmpty()) {
                
                Point p = queue.poll();
                min = Math.min (p.value, min);
                Point nxt = new Point(p.x + dx[cnt], p.y+dy[cnt], map[p.x+dx[cnt]][p.y+dy[cnt]]);

                //경계에 걸렸다면?
                if (isRange(nxt)){
                    if (cnt != 3){
                        ++cnt;
                        int save = map[p.x][p.y];
                        map[p.x][p.y] = pre;
                        pre = save;
                        queue.add(new Point(p.x + dx[cnt], p.y + dy[cnt], pre));  
                    } else {
                        map[p.x][p.y] = pre;
                        // System.out.println(p.x+1+" "+p.y+" "+map[p.x][p.y+1]);
                        answer.add(min);
                        break;    
                    }
                } else {
                    //경계가 아니라면
                    int save = map[p.x][p.y];
                    map[p.x][p.y] = pre;
                    pre = save;
                    queue.add(new Point(p.x + dx[cnt], p.y + dy[cnt], pre));
                }
            }//end of Queue
            
        }
        int[] ans = new int[answer.size()];
        
        for (int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    static public boolean isRange (Point p) {
        if (p.x > b.x || p.x < a.x || p.y < a.y || p.y > b.y 
            || p.x <= 0 || p.x > r || p.y <= 0 || p.y > c)
            return true;
        else
            return false;
    }
    
    static public class Point {
        int x;
        int y;
        int value;
        
        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
