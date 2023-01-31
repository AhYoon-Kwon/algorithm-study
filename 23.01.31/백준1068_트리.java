package Gold;

import java.util.*;
import java.io.*;

public class Q1068_트리 {
	static int n;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		tree = new ArrayList[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; st.hasMoreElements(); i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == -1)
				continue;
			else {
				tree[a].add(i);
			}
		}

		int n = Integer.parseInt(br.readLine());
		q.add(n);

		while (!q.isEmpty()) {
			int a = q.poll();
			if (tree[a].isEmpty())
				continue;
			while (!tree[a].isEmpty()) {
				q.add(tree[a].get(0));
				tree[a].remove(0);
			}
		}

		int answer = 0;

		q.add(0);
		while (!q.isEmpty()) {
			int a = q.poll();
			if (tree[a].isEmpty()) {
				answer++;
				continue;
			}

			for (int i = 0; i < tree[a].size(); i++) {
				q.add(tree[a].get(i));
			}
		}
		System.out.println(answer-1);
	}
}
