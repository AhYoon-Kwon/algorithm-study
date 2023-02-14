import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer> list;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList<>();
        for(int i = 0; i < N; i++)
            list.add(sc.nextInt());

        recur( 0);

        System.out.println(max);
    }

    static void recur(int energy) {
        if(list.size() < 3) {
            max = Math.max(max, energy);
            return;
        }


        for(int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i - 1) * list.get(i + 1);
            int x = list.remove(i);
            recur(energy + temp);
            list.add(i, x);
        }
    }
}
