import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, M, J, S;
    static long min_dist, J_smallest_dis, ans;
    static long [] distJ, distS;                 // 지헌이 최단거리, 성하 최단거리
    static ArrayList<Node>[] lists;
    static ArrayDeque<Node> land_of_promise = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[V + 1];
        distJ = new long [V + 1];
        distS = new long [V + 1];
        Arrays.fill(distJ, Integer.MAX_VALUE);
        Arrays.fill(distS, Integer.MAX_VALUE);
        for (int i = 1; i < V + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());
            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        J = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        dijkstar(true);
        dijkstar(false);

//        System.out.println("지현: " + Arrays.toString(distJ));
//        System.out.println("성하: " + Arrays.toString(distS));

        min_dist = Integer.MAX_VALUE;
        for (int i = 0; i < V + 1; i++) {
            if( i == J || i == S) continue;
            min_dist = (int)Math.min(min_dist, distJ[i] + distS[i]);
        }

        ans = -1;
        J_smallest_dis = Integer.MAX_VALUE;
        for (int i = V ; i >= 1; i --) {
            if( i == J || i == S) continue;
            if(min_dist != distJ[i] + distS[i]) continue;
            if(distJ[i] > distS[i]) continue;
            if(J_smallest_dis >= distJ[i]) {
                J_smallest_dis = distJ[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }

    public static void dijkstar (boolean isJ) {
        int START = isJ? J : S;
        long [] dist = isJ? distJ : distS;
        PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        dist[START] = 0;
        pq.add(new Dist(START, 0));

        while(!pq.isEmpty()) {
            Dist now = pq.poll();

            if(now.dist != dist[now.idx]) continue;

            for (int i = 0; i < lists[now.idx].size(); i++) {
                Node next = lists[now.idx].get(i);
                if(dist[next.idx] > dist[now.idx] + next.w){
                    dist[next.idx] = dist[now.idx] + next.w;
                    pq.add(new Dist(next.idx, dist[next.idx]));
                }
            }
        }
    }
}

class Node {
    int idx;
    int w;

    public Node (int idx, int w){
        this.idx = idx;
        this.w = w;
    }
}

class Dist {
    int idx;
    long dist;

    public Dist(int idx, long dist){
        this.idx= idx;
        this.dist = dist;
    }
}