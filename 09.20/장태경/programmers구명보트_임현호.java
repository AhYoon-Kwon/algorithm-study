import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
    	
        int answer = 0;
        

       Arrays.sort(people);
        
        int last = people.length - 1;
        int first = 0;

        while(last - first >= 0){
            first = people[last--] + people[first] <= limit ? first + 1 : first;
            answer++;
        }
        
        answer = (last == first) ? answer + 1 : answer;

        return answer;
    }
}