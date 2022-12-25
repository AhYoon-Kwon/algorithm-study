import java.util.*;

class Solution {
    public int solution(String str1, String str2) {   
        List<String> stand = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            if(checkChar(str1.charAt(i))&&checkChar(str1.charAt(i+1))){
                String tmp = str1.toUpperCase();
                stand.add(tmp.substring(i, i+2));
            }
        }
        List<String> check = new ArrayList<>();
        for(int i=0; i<str2.length()-1; i++){
            if(checkChar(str2.charAt(i))&&checkChar(str2.charAt(i+1))){
                String tmp = str2.toUpperCase();
                check.add(tmp.substring(i, i+2));
            }
        }
      //두문자 모두 공집합이면 유사도=1
        if(stand.size()==0&&check.size()==0) return 65536;
        
        float inter = 0;
        float union = stand.size()+check.size();
        for(String str: check){
            if(stand.contains(str)){
                stand.remove(str);
                inter+=1;
            }
        }
        union -= inter;
        int answer = (int)Math.floor(inter/union*65536);
        return answer;
    }
  //문자만 골라내기
    static boolean checkChar(char cha){
        if(cha>=65&&cha<=90) return true;
        if(cha>=97&&cha<=122) return true;
        return false;
    }
}
