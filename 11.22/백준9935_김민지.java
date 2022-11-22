import java.io.*;
import java.util.*;

public class 백준9935_김민지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bomb = br.readLine();
        int leng = input.length();
        int bleng = bomb.length();

        Stack<Character> stack = new Stack<>();
        //주어진 문자열을 스택에 넣기
        for (int i = 0; i < leng; i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            //스택에 들어간 문자길이가 폭발문자열 길이보다 커지면 최근 들어온 문자열 기준으로 폭발문자열과 비교
            if (stack.size() >= bleng) {
                boolean flag = true;
                for (int j = 0; j < bleng; j++) {
                    if (stack.get(stack.size() - bleng + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
              //폭발문자열과 같은 문자열은 없애주기
                if (flag) {
                    for (int j = 0; j < bleng; j++) {
                        stack.pop();
                    }
                }
            }
        }
         //스택에 남은 문자열로 결과값 만들기
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        // 모두 폭발해서 없어졌으면 "FRULA" 출력
        String answer = sb.toString();
        if(answer.length()==0) answer ="FRULA";

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}

