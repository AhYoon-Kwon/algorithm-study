package BaekJoon;

import java.util.HashMap;
import java.util.Scanner;

public class 백준17219_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<n; i++) {
			String s1 = sc.next();
			String s2 = sc.next();
			map.put(s1, s2);
		}
		for(int i=0; i<m; i++) {
			System.out.println(map.get(sc.next()));
		}
	}
}
