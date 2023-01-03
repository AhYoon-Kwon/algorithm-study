package Silver;

import java.util.*;
import java.io.*;

public class Q14888_연산자끼워넣기 {
	static int max, min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int ins[] = new int[4];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<a.length;i++) {
			a[i] = Integer.parseInt(st.nextToken());		
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<ins.length;i++) {
			ins[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(a,ins,a[0],1);
		
		System.out.println(max);
		System.out.println(min);
    
	}
	
	static void dfs(int[] a,int[] ins,int num,int idx) {
		if(idx == a.length) {
			max = Math.max(num,max);
			min = Math.min(num,min);
			return;
		}
						
		for(int i=0;i<ins.length;i++) {
			if(ins[i] != 0) {
				
				ins[i]--;

				switch(i) {
					case 0: dfs(a,ins,num+a[idx],idx+1); break;
					case 1: dfs(a,ins,num-a[idx],idx+1); break;
					case 2: dfs(a,ins,num*a[idx],idx+1); break;
					case 3: dfs(a,ins,num/a[idx],idx+1); break;
				}
				
				ins[i]++;	
			}
		}
	}
}
