import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    static int N;
    static long sum = 0;
    static int [] depth = new int [300002];
    static TreeSet<Integer> BST = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        BST.add(0); BST.add(N+1);
        depth[0] = -1; depth[N+1] = -1;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            depth[now] = Math.max(depth[BST.lower(now)], depth[BST.higher(now)]) + 1;
            BST.add(now);
            sum += depth[now];
            answer.append(sum).append("\n");
        }
        System.out.println(answer.toString());
    }
}