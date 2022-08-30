package algo.baekjoon;

import java.util.Scanner;

public class Baekjoon17136_색종이붙이기b {

	static int[][] map;
	static int ans;
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j]=sc.nextInt();
			}
		}//end for map
		
		
		ans = Integer.MAX_VALUE;
		cnt = new int[6];
		
		recursive(0,0);
						
		System.out.println((ans==Integer.MAX_VALUE)?-1:ans);
		
	}
	static void recursive(int x, int y) {
		
		out:
		if(map[x][y]==0) {	
			for(int i=x; i<10; i++) {
				int tmp = (i==x)?y:0;
				for(int j=tmp; j<10; j++) {
					if(map[i][j]==1) {
						x=i; y=j;					
						break out;
					}
				}
			}
			
			int total = 0;
			for(int i=1; i<6; i++) {
				total +=cnt[i];
			}
			ans = Math.min(ans, total);
			return;
		}
		
		int maxLen = 1;
		
		out:
		for(int tmp = 5; tmp>=1; tmp--) {
			for(int s=0; s<tmp; s++) {
				for(int t=0; t<tmp; t++) {
					if(!checkRange(x+s,y+t)) continue out;
					if(map[x+s][y+t]==0) continue out;
				}
			}//end for s,j
			
			maxLen = tmp;
			break;
			
		}//end for finding max length
		
		for(int len=maxLen; len>=1; len--) {
			
			if(cnt[len]>4) continue;
			
			cnt[len]++;

			for(int s=0; s<len; s++) {
				for(int t=0; t<len; t++) {
					map[x+s][y+t]=0;
				}
			}//end for s,j
			
						
			int x2, y2;
			
			if(y+len==10) {
				if(x==9) {
					int total = 0;
					for(int i=1; i<6; i++) {
						total+=cnt[i];
					}
					ans=Math.min(ans, total);
						
					for(int s=0; s<len; s++) {
						for(int t=0; t<len; t++) {
							map[x+s][y+t]=1;
						}
					}
					cnt[len]--;
					
					return;
				}
				else {
					x2=x+1;
					y2=0;
				}
			}else {
				x2 = x;
				y2 = y+len;
			}
			
			recursive(x2,y2);
			
			for(int s=0; s<len; s++) {
				for(int t=0; t<len; t++) {
					map[x+s][y+t]=1;
				}
			}
			cnt[len]--;
		}
	}
	
	static boolean checkRange(int x, int y) {
		if(x<0||x>=10||y<0||y>=10) return false;
		return true;
	}
}
