import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        int len = 1;
        HashSet<String> set = new HashSet<>();

        while(len <= line.length()) {
            for(int i = 0; i < line.length() - len + 1; i++) {
                set.add(line.substring(i, i + len));
            }
            len++;
        }

        System.out.println(set.size());
    }
}
