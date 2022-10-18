class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
		
		for(int j=0; j<n; j++) {
			if(!visit[j]) {
				answer++;
				dfs(j, computers, visit);
			}
		}
        
        return answer;
    }
    
    public static void dfs(int index, int[][] computers, boolean[] path) {
		path[index] = true;
		
		for(int i=0; i<computers.length; i++) {
			if(path[i] == false && computers[index][i] == 1) {
				dfs(i, computers, path);
			}
		}
	}
}