package algo.programmers;

import java.util.PriorityQueue;


//23, 24 실패
public class programmers_실패율 {
	static class info implements Comparable<info> {
		int N;
		int in; int fail;
		info(int N, int in, int fail){
			this.N = N;
			this.in = in;
			this.fail = fail;
		}
		@Override
		public int compareTo(info o) {
			int thisNumerator = this.fail*o.in;
			int oNumerator = o.fail * this.in;
			if(thisNumerator == oNumerator) return this.N - o.N;
			return oNumerator - thisNumerator;
		}
	}
	static int[] inCnt, fCnt;
    public static int[] solution(int N, int[] stages) {
        
    	inCnt = new int[N+2];
    	fCnt = new int[N+2];
    	int total = stages.length; //이용자 수
        for(int i=0; i<stages.length; i++) {
        	for(int j=1; j<=N; j++) {
        		if(stages[i]>=j) {
        			inCnt[j]++;
        		}
        		if(stages[i]==j) fCnt[j]++;        		
        	}
        }
        
        PriorityQueue<info> p = new PriorityQueue<>();
        for(int i=1; i<N+1; i++) {
        	p.add(new info(i, inCnt[i], fCnt[i]));
        }
    	
    	int[] answer = new int[N];
    	for(int i=0; i<N; i++) {
    		answer[i] = p.poll().N;
    		System.out.println(answer[i]);
    	}
        return answer;
    }
    public static void main(String[] args) {
		solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
	}
}
