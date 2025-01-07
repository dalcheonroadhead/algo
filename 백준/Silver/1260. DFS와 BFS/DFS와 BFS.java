import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int V,E,S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ArrayList<Integer> [] lists = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            // 양방향
            lists[start].add(end);
            lists[end].add(start);
        }

        for (int i = 1; i <= V; i++) {
            Collections.sort(lists[i]);
        }

        boolean [] isVisited = new boolean[lists.length];
        dfs(lists, S, isVisited, ans);
        ans.append("\n");
        bfs(lists,S,ans);
        System.out.println(ans);
    }

    public static void dfs(ArrayList<Integer> [] lists, int now, boolean [] isVisited, StringBuilder ans) {
        ans.append(now).append(" ");
        isVisited[now] = true;

        for (int i = 0; i < lists[now].size(); i++) {
            int next = lists[now].get(i);
            if(!isVisited[next]) {
                dfs(lists, next, isVisited, ans);
            }
        }
    }

    public static void bfs (ArrayList<Integer> [] lists, int S, StringBuilder ans){
        boolean [] isVisited = new boolean[lists.length];
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(S);
        isVisited[S] = true;

        while (!aq1.isEmpty()){
            int qSize = aq1.size();
            for (int i = 0; i < qSize; i++) {
                int now = aq1.poll();
                ans.append(now).append(" ");

                for (int j = 0; j < lists[now].size(); j++) {
                    int next = lists[now].get(j);
                    if(!isVisited[next]){
                        isVisited[next] = true;
                        aq1.add(next);
                    }
                }
            }

        }
    }
}