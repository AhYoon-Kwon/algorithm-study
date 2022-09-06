import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        int len = clothes.length;

        List<String> clothList = new ArrayList<String>();
        int[] cnt = new int[len];

        int fin = 0;

        for(int i = 0; i < len; i++){
            int idx = clothList.indexOf(clothes[i][1]);
            if(idx == -1){
                clothList.add(clothes[i][1]);
                cnt[fin++]++;
            } else {
                cnt[idx]++;
            }
        }

        int answer = 1;

        for(int i = 0; i < len; i++){
            answer *= cnt[i]+1;
        }
        answer--;

        return answer;
    }
}