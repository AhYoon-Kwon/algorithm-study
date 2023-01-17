import java.io.*;

public class BOJ_2179 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String [] list = new String[N];
		for(int i=0; i<N; i++)
			list[i]=br.readLine();
	
		int max=0;
		String [] res = new String [2];
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				int cnt = check(list[i], list[j]);
				//접두사 길이 같은게 여러개면 먼저 나온 값을 출력
				if(cnt>max) { 
					res[0]=list[i];
					res[1]=list[j];
					max=cnt;
				}
			}
		}
		System.out.println(res[0]+"\n"+res[1]);
		
	}
	public static int check(String sta, String com) {
		//아예 같은 단어면 제외
		if(sta.equals(com)) return -1;
		int cnt=0;
		for(int i=0; i<sta.length(); i++) {
			if(i>=sta.length()||i>=com.length()) 
				return cnt;
			if(sta.charAt(i)==com.charAt(i))
				cnt++;
		}
		return cnt;
	}
}
