import java.util.*;

class programmers신규아이디추천_권아윤 {
    public static String solution(String new_id) {
        String answer = new_id;
        answer = new_id.toLowerCase();
        String ans = "";
        for(int i = 0; i < answer.length(); i++) {
            char temp = answer.charAt(i);
            if(Character.isAlphabetic(temp) || Character.isDigit(temp) || temp == '-' || temp == '_' || temp == '.') {
                ans += temp;
            }
        }
        answer = ans;
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        answer = delDot(answer);

        if(answer.length() == 0) answer += "a";

        if(answer.length() >= 16) {
            StringBuffer sb = new StringBuffer();

            for(int i = 0; i < 15; i++) {
                sb.append(answer.charAt(i));
            }

            if(answer.charAt(answer.length()-1) == '.') {
                sb.deleteCharAt(answer.length()-1);
            }

            answer = sb.toString();
            answer = delDot(answer);
        }

        if(answer.length() <= 2) {
            char t = answer.charAt(answer.length()-1);

            while(answer.length() < 3) {
                answer += t;
            }
        }


        return answer;
    }

    static String delDot(String answer) {
        if(answer.charAt(0) == '.') {
            StringBuffer sb = new StringBuffer();
            sb.append(answer);
            sb.deleteCharAt(0);
            answer = sb.toString();
        } 
        if(answer.charAt(answer.length()-1) == '.') {
             StringBuffer sb = new StringBuffer();
            sb.append(answer);
            sb.deleteCharAt(answer.length()-1);
            answer = sb.toString();
        }
        return answer;
    }
}
