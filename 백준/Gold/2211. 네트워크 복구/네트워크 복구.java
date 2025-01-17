import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int N,M;
    static ArrayList<Node> [] lists;
    static Dist [] dists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
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
        dijkstra();
        HashSet<Edge> sum = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            sum.addAll(dists[i].routes);
        }
        ans.append(sum.size()).append("\n");
        for (Edge now : sum){
            ans.append(now.start).append(" ").append(now.end).append("\n");
        }
        System.out.println(ans.toString());
    }

    public static void dijkstra () {
        dists = new Dist[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dists[i] = new Dist(i);
        }
        dists[1].dist = 0;

        PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Dist(1,0));

        while(!pq.isEmpty()){
            Dist now = pq.poll();

            if(now.dist != dists[now.idx].dist) continue;

            for (int i = 0; i < lists[now.idx].size(); i++) {
                Node next = lists[now.idx].get(i);
                if(dists[next.idx].dist > dists[now.idx].dist + next.w) {
                    dists[next.idx].dist = dists[now.idx].dist + next.w;
                    dists[next.idx].routes.clear();
                    dists[next.idx].routes.addAll(dists[now.idx].routes);
                    dists[next.idx].routes.add(new Edge(now.idx, next.idx));
                    pq.add(new Dist(next.idx, dists[next.idx].dist, dists[next.idx].routes));
                }
                if(dists[next.idx].dist == dists[now.idx].dist + next.w &&
                    dists[next.idx].routes.size() > dists[now.idx].routes.size() + 1) {
                    dists[next.idx].routes.clear();
                    dists[next.idx].routes.addAll(dists[now.idx].routes);
                    dists[next.idx].routes.add(new Edge(now.idx, next.idx));
                }
            }
        }
    }
}

class Dist {
    int idx;
    int dist;
    HashSet<Edge> routes;

    public Dist (int i) {
        this.idx = i;
        this.dist = Integer.MAX_VALUE;
        routes = new HashSet<>();
    }

    public Dist (int i, int dist){
        this.idx = i;
        this.dist = dist;
    }

    public Dist (int i, int dist, HashSet<Edge> prev){
        this.idx = i;
        this.dist = dist;
        routes = new HashSet<>();
        routes.addAll(prev);
    }

    public String toString() {
        return "[" + idx + ", " + dist + ", " + routes + "]";
    }
}


class Node {
    int idx;
    int w;

    public Node (int idx, int w) {
        this.idx = idx;
        this.w = w;
    }
}

class Edge {
    int start;
    int end;

    public Edge (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int hashCode(){
        return this.start + this.end;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Edge o = (Edge) obj;
        return o.start == this.start && o.end == this.end;
    }
}
