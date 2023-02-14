import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt=0;
        int zero=0;
        for(int num: lottos){
            if(num==0){
                zero++;
                continue;
            }
            for(int i=0; i<win_nums.length; i++){
                if(win_nums[i]==num){
                    cnt++;
                }
            }
        }
        answer[0]=7-(cnt+zero);
        answer[1]=7-cnt;
        answer[0]=answer[0]==7?6:answer[0];
        answer[1]=answer[1]==7?6:answer[1];
        return answer;
    }
}
