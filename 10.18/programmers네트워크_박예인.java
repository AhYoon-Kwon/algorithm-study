class Solution {
    static boolean[] check;
    static int[][] map;
    
    public int solution(int n, int[][] computers) {
        
        int cnt = 0;
        
        check = new boolean[n];
        map = computers;
        
        for (int i = 0; i < n; i++){
            if (check[i] != true)
                {dfs(i);
                 cnt++;}
        }
        return cnt;
    }
    
    public static void dfs(int idx){
        check[idx] = true;
        for (int i =0; i<check.length; i++){
            if (map[idx][i] == 1 && check[i] == false)
                dfs(i);
        }
    }
}
