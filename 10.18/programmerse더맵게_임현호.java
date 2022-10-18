import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Long> pq = Arrays.stream(scoville)
            .asLongStream()
            .mapToObj(Long::new)
            .collect(Collectors.toCollection(PriorityQueue::new));

        int answer = 0;
        

        while(pq.size() > 1 && pq.peek() < K) {
            long food = pq.poll() + pq.poll() * 2;
            pq.add(food);
            answer++;
        }

       answer = pq.peek() >= K ? answer : -1;

       return answer;
    }
}