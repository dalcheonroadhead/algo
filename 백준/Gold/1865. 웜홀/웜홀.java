import java.io.*;
import java.util.*;

public class Main{
    static int TC, N, M, W;
    static Edge [] edges;
    static ArrayList<Edge> [] lists;
    static long [] dist;
    static StringBuilder answer = new StringBuilder();
    static class Edge {
        int s;
        int e;
        int w;

        public Edge (int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edges = new Edge[2*M+W];
            dist = new long [N+1];
            lists = new ArrayList[N+1];

            for (int i = 0; i < N+1; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < 2*M; i+=2) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(s,e,w);
                edges[i+1] = new Edge(e,s,w);
                lists[s].add(new Edge(s,e,w));
                lists[e].add(new Edge(e,s,w));
            }

            for (int i = 2*M; i < 2*M+W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(s,e,-w);
                lists[s].add(new Edge(s,e,-w));
            }
            execute();
        }
        System.out.println(answer);
    }

    public static void execute() {
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < edges.length; k++) {
                    mitigation(k);  // 완화 작업
                }
            }
            for (int k = 0; k < edges.length; k++) {
                if(mitigation(k)) {
                    answer.append("YES").append("\n");
                    return;
                }
            }
        answer.append("NO").append("\n");
        return;
    }

    public static boolean mitigation(int i) {
        int s = edges[i].s;
        int e = edges[i].e;
        int w = edges[i].w;
        if(dist[s] + w < dist[e]){
            dist[e] = dist[s]+w;
            return true;
        }
        return false;
    }
}