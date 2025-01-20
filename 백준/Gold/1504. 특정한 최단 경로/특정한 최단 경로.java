import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static class Node {
        int i;
        int w;

        public Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static class Dist {
        int idx;
        int dist;

        public Dist (int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static int N, E, A, B;
    static ArrayList<Node>[] lists;
    static int iter = 0;
    static int [][] dists;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        dists = new int[3][N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        // 계산
        dijkstra(1);
        dijkstra(A);
        dijkstra(B);
        long ans1 = dists[0][A] + dists[1][B] + dists[2][N];
        long ans2 = dists[0][B] + dists[2][A] + dists[1][N];
        if(dists[0][A] == Integer.MAX_VALUE || dists[1][B] == Integer.MAX_VALUE || dists[2][N] == Integer.MAX_VALUE) ans1 = Integer.MAX_VALUE;
        if(dists[0][B] == Integer.MAX_VALUE || dists[2][A] == Integer.MAX_VALUE || dists[1][N] == Integer.MAX_VALUE) ans2 = Integer.MAX_VALUE;
        // 출력
        System.out.println(Math.min(ans1, ans2) == Integer.MAX_VALUE? -1 : Math.min(ans1,ans2));
    }

    public static void dijkstra(int start) {
        int [] dist = find_dist(start);
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        dist[start] = 0;
        pq.add(new Dist(start, 0));
        while (!pq.isEmpty()){
            Dist now = pq.poll();
            if(now.dist != dist[now.idx]) continue;
            for (int i = 0; i < lists[now.idx].size(); i++) {
                Node next = lists[now.idx].get(i);
                if(dist[next.i] > dist[now.idx] + next.w) {
                    dist[next.i] = dist[now.idx] + next.w;
                    pq.add(new Dist(next.i, dist[next.i]));
                }
            }
        }
    }
    public static int[] find_dist(int start){
        return dists[iter++];
    }
}
