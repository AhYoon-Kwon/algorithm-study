import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities){
        int answer = 0;
        int len = cities.length;
        int howManyInCache = 0;
        
        if(cacheSize > 0){
            String[] cache = new String[cacheSize];
            for(int i = 0; i < len; i++){
//              check
                boolean flag = false;
                int hitIdx = 0;
                String city = cities[i].toUpperCase();

                for(int f = 0; f < howManyInCache; f++){
                    if(cache[f].equals(city)){
                        // System.out.println("idx " + i);
                        flag = true;
                        hitIdx = f;
                        break;
                    }
                }
//              hit
                if(flag){
                    answer += 1;
                    for(int k = hitIdx; k < howManyInCache - 1; k++){
                        cache[k] = cache[k + 1];
                    }
                    cache[howManyInCache - 1] = city;
                }else{
//              miss
                    answer += 5;
                    if(howManyInCache < cacheSize){
                        cache[howManyInCache] = city;
                        howManyInCache++;
                    }else{
                        for(int j = 0; j < cacheSize - 1; j++){
                            cache[j] = cache[j+1];
                        }
                        cache[howManyInCache - 1] = city;
                    }
                }
                // System.out.println(Arrays.toString(cache));
            }
        }else{
            answer = len * 5;
        }
        
        return answer;
    }
}
