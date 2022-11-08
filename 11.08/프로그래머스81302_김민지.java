//76

import java.util.*;
class Solution {
    static char [][] box;
    static boolean [][] visit;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static Queue<Node> que;
    public static class Node{
        int x, y, cnt;
        Node(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt; //이동횟수
        }
    }
    public int[] solution(String[][] places) {
        int order=places.length;
        int[] answer = new int[order];
        //각 테케 나누기
        for (int i = 0; i < order; i++) {
            //배열쪼개서 개별 [][] 로 만들기
            makeBox(places[i]);
            //만약 응시자가 아무도 없는 경우 1
            if(que.isEmpty()) answer[i]=1;
            //응시자가 있는 경우 거리두기 확인
            else answer[i]=bfs();
            
        }
        return answer;
    }
    //개별 [][] 만들기
     private static void makeBox(String[] places) {
        box = new char[5][5];
        que = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 5; j++) {
                box[i][j] = places[i].charAt(j);
                if (box[i][j]=='P') {
                    //응시자의 위치 que에 add
                    que.add(new Node(i, j,0));
                }
            }
        }
     }
    
    private static boolean isOut(int x, int y ){
        if(x<0||y<0||x>=5||y>=5) return true;
        return false;
    }
         
    private static int bfs(){
        visit = new boolean[5][5];
        while(!que.isEmpty()){
            Node cur = que.poll();
            visit[cur.x][cur.y]=true;
            if(cur.cnt==2) continue;
            for(int idx=0; idx<4; idx++){  
                int i = cur.x+dx[idx];
                int j = cur.y+dy[idx];
                if(isOut(i, j)||visit[i][j]) continue;
                if(box[i][j]=='P') return 0;
                if(box[i][j]=='O')
                    que.add(new Node(i, j, cur.cnt+1));
            }
        }
        return 1;
    }   
}
