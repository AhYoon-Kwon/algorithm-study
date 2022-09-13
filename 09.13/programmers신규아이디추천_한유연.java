package algo.programmers;

import java.util.*;

class programmers_신규아이디추천 {
    
    public String solution(String new_id) {
        
        Queue<Character> arr = new LinkedList<>();
       
        int len = new_id.length();
        for(int i=0; i<len; i++){
            char c = new_id.charAt(i);
            
            if(97<=c && c<=122){
                arr.add(c);
            }
            else if(65<=c && c<=90){
                arr.add((char)(c+32));
            }else if(48<= c && c<=57){
                arr.add(c);
            }else if(c==45 || c==95 || c==46){
                arr.add(c);
            }
            
        }
       
        Queue<Character> arr2 = new LinkedList<>();
        
        while(!arr.isEmpty()){
            char c = arr.poll();
            
            if(c==46){
                while(!arr.isEmpty() && arr.peek()==46){
                    arr.poll();
                }
                if(arr.isEmpty()) break;
            }
            
            arr2.add(c);
        }
        if(!arr2.isEmpty() && arr2.peek() == 46) arr2.poll();
        
        
        if(arr2.size()==0) return "aaa";
        
        String answer = "";
        
        if(arr2.size()>=16){
            for(int i=0; i<14; i++){
                answer = answer + arr2.poll();
            }
            
            
            if(arr2.peek()==46){
                return answer;
            }
            else{
                answer +=arr2.poll();
                return answer;
            }
        }
        if(arr2.size()==1){
            char c = arr2.poll();
            for(int i=0; i<3; i++) answer += c;
            
            return answer;
        }
        else if(arr2.size()==2){
            char c = arr2.poll();
            answer += c;
            c = arr2.poll();
            answer += c;
            answer += c;
            return answer;
        }
        
        while(!arr2.isEmpty()){
            answer += arr2.poll();
        }
        return answer;
    }
}