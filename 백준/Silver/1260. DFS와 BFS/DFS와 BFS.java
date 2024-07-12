import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> [] list;
    static boolean [] isVisited;
    static int N,M,V;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());

            if(!list[start].contains(end)){
                list[start].add(end);
                list[end].add(start);
            }
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        isVisited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        isVisited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs (int now) {
        isVisited[now] = true;
        sb.append(now).append(" ");
        for (int i = 0; i < list[now].size(); i++) {
            int next = list[now].get(i);
            if(!isVisited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int v) {
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(v);
        isVisited[v] = true;
        while (!aq1.isEmpty()){
            int now = aq1.poll();
            sb.append(now).append(" ");
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if(!isVisited[next]){
                    isVisited[next] = true;
                    aq1.add(next);
                }
            }
        }
    }
}