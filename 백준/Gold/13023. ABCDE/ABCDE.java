import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] lists;
    static boolean [] isVisited;
    static boolean isValid = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }
        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(0,i);
            isVisited[i] = false;
            if(isValid) break;
        }
        if(!isValid) System.out.println(0);
        else System.out.println(1);
    }
    public static void dfs(int depth, int vertex) {
        if(depth == 4){
            isValid = true;
            return;
        }

        for (int i = 0; i < lists[vertex].size(); i++) {
            int next = lists[vertex].get(i);
            if(!isVisited[next]){
                isVisited[next] = true;
                dfs(depth+1, next);
                if(isValid) return;
                isVisited[next] = false;
            }
        }
    }
}