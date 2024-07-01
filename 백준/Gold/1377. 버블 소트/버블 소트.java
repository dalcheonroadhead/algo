import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node [] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            Node now = new Node(i, Integer.parseInt(br.readLine()));
            nodes[i] = now;
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.value));

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nodes[i].idx - i);
        }

        System.out.println(++max);
    }
}

class Node {
    int idx;
    int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}