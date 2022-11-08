import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int len = cmd.length;
//      삭제 기록 저장
        Stack<Integer> history = new Stack<Integer>();
        
        for(int i = 0; i < len; i++){
            char order = cmd[i].charAt(0);
            
            if(order == 'U'){
                k -= Integer.parseInt(cmd[i].substring(2));
            }else if(order == 'D'){
                k += Integer.parseInt(cmd[i].substring(2));
            }else if(order == 'C'){
                history.push(k);
                if(k == n - history.size()){
//                  삭제한게 마지막 부분인 경우
                    k--;
                }
            }else if(order == 'Z'){
                int idx = history.pop();
                if(idx <= k){
//                  복구된 부분이 나와 같거나 위에 있는 경우
                    k++;
                }
            }
        }
        StringBuffer buf = new StringBuffer("");
        for(int i = 0; i < n - history.size(); i++){
            buf.append("O");
        }
//      삭제 기록하나씩 꺼내서 
        while(!history.isEmpty()){
            buf.insert(history.pop(), "X");
        }
        String answer = buf.toString();
        return answer;
    }
}
