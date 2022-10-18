import java.util.*;

//기본 dfs
class programmers네트워크_권아윤 {
    static int answer = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    
    public int solution(int n, int[][] computers) {
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                
                //같은 노드 패스
                if(i == j) continue;
                
                //컴퓨터 연결~
                if(computers[i][j] == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        visited = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            //방문안했으면 체크~
            if(!visited[i]) {
                dfs(n, computers, i); 
                answer++;
            }
        }

        return answer;
    }
    
    static void dfs(int n, int[][] computers, int d) {
        //해당 노드 방문 처리 후
        visited[d] = true;
        
        for(int i = 0; i < list.get(d).size(); i++) {
            int now = list.get(d).get(i);
            
            //방문안했으면 재귀
            if(!visited[now]) {
                visited[now] = true;
                dfs(n, computers, now);
            }
        }
    }
}
