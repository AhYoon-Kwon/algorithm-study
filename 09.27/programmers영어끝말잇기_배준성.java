import java.util.Arrays;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        String[] tmp = new String[words.length];
                
        for(int i = 0; i < words.length; i++){
            if(Arrays.stream(tmp).anyMatch(words[i]::equals) || 
               (i>0 && tmp[i-1].charAt(tmp[i-1].length()-1) != words[i].charAt(0))){
                int[] ans = {(i%n)+1, (i/n)+1};
                answer = ans;
                break;
            }
            tmp[i] = words[i];
        }
        if(answer.length==0){
            answer = new int[2];
        }

        return answer;
    }
}
