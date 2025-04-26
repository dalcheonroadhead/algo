import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static final long NOT_INIT = Long.MIN_VALUE;
    static int n, start_city, end_city, m;
    static long [] dist;
    static int [] earn;
    static Edge [] edges;
    static ArrayList<Edge> [] lists;
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 1; i < n; i++){
            enforcement();
        }
        long [] temp = new long [n];

        for (int i = 0; i < n; i++) {
            temp[i] = dist[i];
        }

        if(dist[end_city] == NOT_INIT) {
            System.out.println("gg");
            return;
        } else if(enforcement()) {
            for (int i = 0; i < n; i++) {
                if(temp[i] != dist[i]) {
                    if (bfs(i)) {
                        System.out.println("Gee");
                        return;
                    }
                }
            }
        }
        System.out.println(dist[end_city]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start_city = Integer.parseInt(st.nextToken());
        end_city = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long [n];
        earn = new int [n];
        lists = new ArrayList[n];
        edges = new Edge[m];

        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end    = Integer.parseInt(st.nextToken());
            int cost   = Integer.parseInt(st.nextToken());
            Edge now = new Edge(start, end, cost);
            edges[i] = now;
            lists[start].add(now);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dist, NOT_INIT);
        dist[start_city] = earn[start_city];
    }

    public static boolean enforcement () {
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            if( dist[edges[i].start] != NOT_INIT &&
                dist[edges[i].start] + earn[edges[i].end] - edges[i].weight > dist[edges[i].end]){
                dist[edges[i].end] = dist[edges[i].start] + earn[edges[i].end] - edges[i].weight;
                ans = true;
            }
        }
        return ans;
    }

    public static boolean bfs(int start) {
        boolean [] isVisited = new boolean[n];
        ArrayDeque<Edge> aq1 = new ArrayDeque<>();
        aq1.add(new Edge(start, 0, 0));
        isVisited[start] = true;

        while (!aq1.isEmpty()){
            Edge cur = aq1.poll();

            for (int i = 0; i < lists[cur.start].size(); i++) {
                Edge next = lists[cur.start].get(i);

                if(next.end == end_city) return true;

                if(!isVisited[next.end]) {
                    isVisited[next.end] = true;
                    aq1.add(new Edge(next.end, 0, 0));
                }
            }
        }
        return false;
    }
}