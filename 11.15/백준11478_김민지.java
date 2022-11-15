import java.util.*;

public class 백준11478_김민지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Set<String> set = new HashSet<>();
		char [] indi = input.toCharArray();

		for(int i = 1; i < input.length()+1; i++) {
    		for (int j = 0; j < input.length() - i + 1; j++) {
    			set.add(input.substring(j,j+i));
    		}
    	}
        System.out.println(set.size());
	}
}
