package algo.programmers;

import java.util.HashMap;

public class programmers_위장 {
	static int answer;
	static HashMap<String, Integer> map;
    public int solution(String[][] clothes) {
        
    	map = new HashMap<>();

        int N = clothes.length;

        for(int i=0; i<N; i++) {
            map.put(clothes[i][1], 0);
        }

        for(int i=0; i<N; i++) {
            map.put(clothes[i][1], map.get(clothes[i][1])+1);
        }
        
        answer = 1;
        for(String key : map.keySet()) {
        	answer *= (map.get(key)+1);
        }
        
        return answer-1;
    }


}
