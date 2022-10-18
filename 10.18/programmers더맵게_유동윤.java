import java.util.PriorityQueue;

public class programmers더맵게_유동윤 {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville,K));
	}

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.peek() < K) {
            if (pq.size() == 1)
                return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        return answer;
    }
}
