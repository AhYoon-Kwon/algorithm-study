package algo.programmers;

import java.util.ArrayList;

public class programmers_기능개발 {
	static class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        
	        int N = progresses.length;
	        
	        int[] days = new int[N];
	        for(int i=0; i<N; i++) {
	        	out:
	        	for(int j=0; j<100; j++) {
	        		if(progresses[i]+j*speeds[i]>=100) {
	        			days[i] = j;
	        			break out;
	        		}
	        	}
	        }
	        
	        ArrayList<Integer> ansArr = new ArrayList<>();
	        int tmpMax = days[0];
	        int tmpDay = 1;
	        for(int i=1; i<N; i++) {
	        	if(days[i]>tmpMax) {
	        		ansArr.add(tmpDay);
	        		tmpMax = days[i];
	        		tmpDay = 1;
	        	}else {
	        		tmpDay++;
	        	}
	        }
	        if(tmpDay!=0) ansArr.add(tmpDay);
	        
	        int n = ansArr.size();
	        int[] answer = new int[n];
	        for(int i=0; i<n; i++) {
	        	answer[i] = ansArr.get(i);
	        }
	        
	        return answer;
	    }
	}
}
