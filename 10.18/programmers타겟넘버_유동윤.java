class Solution {
    
    static int[] num;
    static int tar, ans;
        
    public int solution(int[] numbers, int target) {
        ans = 0;
        num = numbers;
        tar = target;
        dfs(0,0);          
        return ans;
    }
    
    public static void dfs(int dept, int sum){
        //끝내
        if(dept>=num.length){
            if(sum==tar){
                ans++;
            }
            return;
        }
        
        //+하고가자
        dfs(dept+1, sum+num[dept]);
        
        //-하고가자
        dfs(dept+1, sum-num[dept]);
    }
}