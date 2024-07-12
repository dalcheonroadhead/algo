import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Node> [] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, weight));
            }
        }
        Node far_node  = bfs(1);
        Node ans_node = bfs(far_node.v);
        System.out.println(ans_node.w);
    }
    // 현 노드에서 제일 먼 Node 출력
    public static Node bfs (int start) {
        int max_vertex = 0;
        int max_weight = 0;
        boolean [] isVisited = new boolean[V+1];
        ArrayDeque<Node> aq1 = new ArrayDeque<>();

        aq1.add(new Node(start, 0));
        isVisited[start] = true;

        while (!aq1.isEmpty()){
            Node now = aq1.poll();
            if(now.w > max_weight){
                max_vertex = now.v;
                max_weight = now.w;
            }
            for (int i = 0; i < list[now.v].size(); i++) {
                Node next = list[now.v].get(i);
                if(!isVisited[next.v]){
                    isVisited[next.v] = true;
                    aq1.add(new Node(next.v, now.w + next.w));
                }
            }

        }

        return  new Node(max_vertex, max_weight);
    }
}

class Node {
    int v;
    int w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }
}