import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		LinkedList<Integer> list = new LinkedList<>();
		int sum = 0;
		for (String s: str) {
			int m = Integer.parseInt(s);
			sum += m;
			list.add(m);
		}
        Collections.sort(list, (o1, o2) -> {
            return o1 - o2;
    });

		int max = Integer.parseInt(br.readLine());
		if (sum <= max)
			{System.out.print(list.peekLast());
			return;}
		int avg = max / n;
		while (!list.isEmpty()) {
			if (list.peekFirst() <= avg) {
				int a = list.getFirst();
				list.remove(0);
				max -= a;
				avg = max / (n-1);
			}else {
				break;
			}
		}
		System.out.println(max/list.size());
	}
}
