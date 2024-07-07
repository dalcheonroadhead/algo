import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer> [] lists;
    static boolean [] isVisited;

    public static void main(String[] args) throws IOException{
        // 0. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        lists = new ArrayList[V+1];
        isVisited = new boolean[V+1];
        for (int i = 0; i < V+1; i++) {
           lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }
        int cnt = 0;
        for (int i = 1; i < V+1; i++) {
            if(!isVisited[i]){
                dfs(i);
                cnt++;
            }
        }


        System.out.println(cnt);
    }

    public static void dfs(int now) {
        for (int i = 0; i < lists[now].size(); i++) {
            int next = lists[now].get(i);
            if(!isVisited[next]){
                isVisited[next] = true;
                dfs(next);
            }
        }
    }
}