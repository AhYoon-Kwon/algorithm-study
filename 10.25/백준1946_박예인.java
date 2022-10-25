import java.util.*;

class Person implements Comparable<Person> {
	int A;
	int B;
	
	Person (int a, int b){
		this.A = a;
		this.B = b;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.A - o.A;
	}
	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t =0; t<T; t++) {
			int n = sc.nextInt();
			Person[] p = new Person[n];
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				p[i] = new Person(a,b);
			}
			Arrays.sort(p);
			
			int cnt = 1;
			int min = p[0].B;

			for (int i = 1; i < n; i++) {
				if (p[i].B <= min) {
					min = p[i].B;
					cnt++;
				}		
			}
			System.out.println(cnt);
		}
	}
}
