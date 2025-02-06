import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {
    static int N, M;
    static int [][] edge_list;
    static ArrayList<Node> [] lists;
    static int [] dists, temp;
    static int [] where_are_you_from;
    static class Node {
        int end;
        int weight;

        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public void solution () throws  IOException {
        input();
        if (!bellman_ford()) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = N;
        while (i != 0) {
            sb.insert(0, i).insert(0, " ");
            i = where_are_you_from[i];
        }
        String answer = sb.toString().trim();
        System.out.println(answer);
    }
    public void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dists = new int [N+1];
        lists = new ArrayList [N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        edge_list = new int[M][3];
        where_are_you_from = new int [N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());
            edge_list[i] = new int [] {start, end, weight};
            lists[start].add(new Node( end, weight));
        }
        Arrays.sort(edge_list, (a,b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
    }

    public boolean bellman_ford () {
        Arrays.fill(dists, -(Integer.MAX_VALUE - 1));
        dists[1] = 0;
        for (int i = 0; i < N; i++) mitigation();
        return is_cycle_and_go_to_N();
    }

    public void mitigation () {
        for (int j = 0; j < M; j++) {
            int start   = edge_list[j][0];
            int end     = edge_list[j][1];
            int weight  = edge_list[j][2];
            if(dists[start] == - (Integer.MAX_VALUE - 1)) continue;
            if(dists[start] + weight > dists[end]) {
                dists[end]  = dists[start] + weight;
                where_are_you_from[end] = start;
            }
        }
//        System.out.println(Arrays.toString(dists));
    }

    public boolean is_cycle_and_go_to_N(){
        for (int j = 0; j < M; j++) {
            int start   = edge_list[j][0];
            int end     = edge_list[j][1];
            int weight  = edge_list[j][2];
            if(dists[start] == - (Integer.MAX_VALUE - 1)) continue;
            if(dists[start] + weight > dists[end]) {
                if(!bfs(start)) return false;
            }
        }
        return true;
    }

    public boolean bfs (int target_vertex) {
        boolean [] isVisited = new boolean[N + 1];
        ArrayDeque<Node> aq1 = new ArrayDeque<>();
        aq1.add(new Node(target_vertex, 0));
        isVisited[target_vertex] = true;

        while (!aq1.isEmpty()){
            int qSize = aq1.size();
            for (int i = 0; i < qSize; i++) {
                Node now = aq1.poll();
                for (int j = 0; j < lists[now.end].size(); j++) {
                    Node next = lists[now.end].get(j);
                    if(!isVisited[next.end]){
                        if(next.end == N) return false;
                        aq1.add(next);
                        isVisited[next.end] = true;
                    }
                }
            }
        }
        return true;
    }
}