
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 백준1449_김민지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int [] leaks = new int [N];
		for(int i=0; i<N; i++) {
			leaks[i]=sc.nextInt();
		}
		Arrays.sort(leaks);
		Stack<Integer> stack = new Stack<>();
		stack.add(leaks[0]);
		for(int i=1; i<N; i++) 
			if(stack.peek()+L<=leaks[i]) {
				stack.add(leaks[i]);
			}
		int count =0;
		while(!stack.isEmpty()) {
			stack.pop();
			count++;
		}
		System.out.print(count);
		
	}
}
