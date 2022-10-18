import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        
//         우선순위 큐에 입력, 정렬 -> 작은게 위로
        for(int oneSc : scoville){
            heap.offer(oneSc);
        }
        
        int answer = 0;
        
        while(heap.peek() <= K){
            if(heap.size() == 1){
                answer = -1;
                break;
            }
            int first = heap.poll(); //가장 맵지 않은
            int second = heap.poll(); //두번째로 맵지 않은
            
            int newOne = first + (second * 2);
            
            heap.offer(newOne);
            answer++;
        }
        
        return answer;
    }
}
