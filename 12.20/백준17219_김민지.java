import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N ; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i=0; i<M; i++) {
			input = br.readLine();
			bw.write(map.get(input));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
