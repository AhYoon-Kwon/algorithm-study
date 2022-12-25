import java.util.*;

//LRU:가장 오랫동안 참조하지 않은 페이지를 캐시에서 교체
//cache hit: 캐시에 해당 데이터 존재함.
//cache miss: 캐시에 해당 데이터가 존재하지않음

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length*5;
        
        LinkedList<String> list = new LinkedList<>();
        int answer =0;
        for(int i=0; i<cities.length; i++){
            String tmp = cities[i].toUpperCase();
            if(list.contains(tmp)){
                answer+=1;
                list.remove(list.indexOf(tmp));
                list.addLast(tmp);
            }else if(list.size()<cacheSize){
                answer+=5;
                list.add(tmp);
            }else{
                answer+=5;
                list.removeFirst();
                list.addLast(tmp);
            }
        }
        
        return answer;
    }
}
