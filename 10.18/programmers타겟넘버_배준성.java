class Solution {
    static int[] N;
    static int tar;
    static int size;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers;
        tar = target;
        size = numbers.length;
        
        answer = 0;
        
        dfs(0, 0);
        
        return answer;
    }
//   원하는 숫자 나오는지 완전 탐색
    static void dfs(int idx, int sum){
        if(idx == size){
            if(tar == sum){
                answer++;
            }
            return;
        }
        dfs(idx + 1, sum + N[idx]);
        dfs(idx + 1, sum - N[idx]);
    }
}
