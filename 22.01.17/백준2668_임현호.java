import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();


        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            search(i, i);
            visited[i] = false;
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);

    }
    static void search(int idx, int next) {
        if(!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            search(arr[idx], next);
            visited[arr[idx]] = false;
        }

        if(arr[idx] == next) {
            list.add(next);
        }

    }

}
