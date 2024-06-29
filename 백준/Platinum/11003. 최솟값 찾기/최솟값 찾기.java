import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayDeque<Node> aq1 = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            Node now = new Node(i, Integer.parseInt(st.nextToken()));

            if(aq1.isEmpty()) aq1.add(now);
            else{
                if(now.idx - L > 0 && aq1.getFirst().idx <= now.idx - L) aq1.poll();

                while(!aq1.isEmpty() && aq1.getLast().v > now.v){
                    aq1.pollLast();
                }

                aq1.add(now);
            }

            sb.append(aq1.getFirst().v).append(" ");
        }

        System.out.println(sb);

    }
}

class Node {
    int idx;
    int v;

    public Node(int idx, int v){
        this.idx = idx;
        this.v = v;
    }
}