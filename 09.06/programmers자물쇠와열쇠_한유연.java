package algo.programmers;

public class programmers_자물쇠와열쇠 {
	
	static int N, M, K, H;
	
    public static boolean solution(int[][] key, int[][] lock) {
    	M = key.length; //M<=N
    	N = lock.length;
    	
    	
    	K = N + 2*M -2;
    	int[][] graph = new int[K][K];
    	
    	for(int i=M-1; i<N+M-1; i++) {
    		for(int j=M-1; j<N+M-1; j++) {
    			graph[i][j] = lock[i-M+1][j-M+1];
    			if(graph[i][j]==0) H++;
    		}
    	}
    	
    
    	   
    	for(int i=0; i<4; i++) {
    		turn(key);
    		if(checkValid(graph, key)) return true;
    	}
    	return false;
    	
    }
    static void turn(int[][] key) {
    	int[][] newMap = new int[M][M];
    	
    	for(int x=0; x<M; x++) {
    		for(int y=0; y<M; y++) {
    			newMap[y][M-1-x] = key[x][y];
    		}
    	}
    	for(int x=0; x<M; x++) {
    		for(int y=0; y<M; y++) {
    			key[x][y] = newMap[x][y];
    		}
    	}

    
    }
    static boolean checkValid(int[][] graph, int[][] key) {
    	
    	for(int i=0; i<=K-M; i++) {
    		out:
    		for(int j=0; j<=K-M; j++) {
    			int cnt = 0;
    			for(int s=0; s<M; s++) {
    				for(int t=0; t<M; t++) {
    					if(!checkRange(i+s,j+t)) continue;
    					if(graph[i+s][j+t]==key[s][t]) {
    						continue out;
    					}
    					if(graph[i+s][j+t]==0) cnt++;
    				}
    			}//end for s, t
    			if(cnt == H) return true;
    		}
    	}
    	return false;
    	
    }
    static boolean checkRange(int x, int y) {
    	if(x<M-1 || x>K-M || y<M-1 || y>K-M) return false;
    	return true;
    }
  
    
    public static void main(String[] args) {
		int[][] key = {{0,0},{0,0}};
		int[][] lock = {{1,0,0},{1,0,0},{1,1,1}};
    	System.out.println(solution(key,lock));
	}
}
