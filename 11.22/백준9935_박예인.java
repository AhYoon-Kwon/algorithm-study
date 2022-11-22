import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
    
    //string replace 사용 -> 메모리 초과
//		while (str.contains(target)&& str.length() !=0) {
//			str = str.replaceAll(target,"");
//		}
//		System.out.println(str.length() == 0 ? "FRULA" : str);
		
		//스택 사용
		Stack<Character> stk = new Stack<>();
		for (int i=0; i<str.length(); i++) {
			stk.add(str.charAt(i));
      //스택이 터지는 문자열보다 크기가 작으면 continue;
			if (stk.size() < target.length()) continue;	
      
			boolean flag = true;
      
			for (int j=0; j<target.length(); j++) {
        //하나라도 다르면
				if (stk.get(stk.size()-target.length()+j) != target.charAt(j))
				  {	flag = false;
					break;}
			  }
				if (flag) {
					for (int j=0; j<target.length(); j++) 
						stk.pop();	
				}
			} // end for 문
    
		StringBuilder sb = new StringBuilder();
		for (char c : stk) 
			sb.append(c);
		System.out.println(stk.isEmpty() ? "FRULA" : sb.toString());
		}		
	}	
