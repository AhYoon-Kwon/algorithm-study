import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] map;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        map = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            map[i] = new ArrayList<>();
        }
        
//       연결된 노드 번호를 map에 채움
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    map[i].add(j);
                    map[j].add(i);
                }
            }
        }
        
        int answer = 0;
      
//       노드를 돌면서 처음 방문하는 노드 덩어리를 체크
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
                
        return answer;
    }
//   DFS
    static void dfs(int idx) {
		if(visited[idx])
			return;
		
		visited[idx] = true;
		for(int i = 0; i < map[idx].size(); i++) {
			if(map[idx].get(i) != idx){
				dfs(map[idx].get(i));
            }
		}
	}
}
