import java.util.*;

class Solution {
    public int solution(String s) {
        //idx = 숫자, value = "해당 숫자 영어"
        String [] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++){
            s=s.replaceAll(num[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
