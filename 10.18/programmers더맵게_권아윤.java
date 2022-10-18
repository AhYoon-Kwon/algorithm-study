import java.util.*;

class programmers더맵게_권아윤 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //처음엔 매번 재정렬하면서 비교.. 시간초과 실패
        //힙(우선순위 큐) : 자동 오름차순
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            //힙에 값넣기!! 자동으로 오름차순 정렬됨
            heap.add(scoville[i]);
        }
        
        while(heap.peek() < K) {
            //제일 작은 값 두개
            int min1 = heap.poll();
            int min2 = heap.poll();
            
            //힙에 넣어주고 K이상인 음식이 되었으므로 answer++
            heap.add(min1 + min2*2);
            answer++;
            
            //제일 작은 값이 K보다 크면 더이상 K이상으로 만들 필요가 없어~
            if(heap.peek() >= K) break;
            
            //모든 음식을 K이상으로 만들 수 없으면 정답은..-1
            if(heap.peek() < K && heap.size() == 1) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
