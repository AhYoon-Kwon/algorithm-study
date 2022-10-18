class programmers타겟넘버_권아윤 {   
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    /* 
    @params:
    numbers - 사용할 숫자가 담긴 배열
    target - 타겟 넘버 (결과로 낼 숫자)
    idx - 지금 체크한 숫자 인덱스
    sum - 숫자 조합의 합
    */
    static void dfs(int[] numbers, int target, int idx, int sum) {
        //종료조건 : 다섯개를 전부 탐색했을 때
        if(idx == numbers.length) {
            //또, 그 다섯개의 숫자의 합(sum) 이 target과 같으면 answer+1한다.
            if(sum == target) answer++;
        }
        //두가지 버전 (+, -)의 재귀를 돌려야 한다.
        else {
            dfs(numbers, target, idx+1, sum+numbers[idx]);
            dfs(numbers, target, idx+1, sum-numbers[idx]);
        }
    }
}
