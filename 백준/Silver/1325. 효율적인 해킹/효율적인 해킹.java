import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        init(n, m, br);

        int max = 0;
        int [] arr = new int [n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = bfs(i);
            max = Math.max(max, arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] == max? i+" " : "");
        }
    }

    public static int bfs(int x) {
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        boolean[] isVisited = new boolean[lists.length + 1];
        aq1.add(x);
        isVisited[x] = true;

        int cnt = 0;
        while (!aq1.isEmpty()) {
            int now = aq1.poll();
            for (int i = 0; i < lists[now].size(); i++) {
                int next = lists[now].get(i);
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    aq1.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void init(int n, int m, BufferedReader br) throws IOException {
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[end].add(start);
        }
    }
}