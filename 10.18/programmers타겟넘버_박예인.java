class Solution {
    public static int[] num;
    public static int t, method;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        num = numbers;
        t = target;
        
        dfs (0, 0);
        return method;
    }
    public void dfs(int idx, int sum){
        if (idx == num.length) {
            if (sum == t) method++;
            return;
        } else
        {
        int plus = sum + num[idx];
        int minus = sum - num[idx];
        idx++;
        dfs(idx, plus);
        dfs(idx, minus);
        }
    }
}
