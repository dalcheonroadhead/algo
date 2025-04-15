import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer> [] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        init(n,m,br);
        bfs(k,x);
    }

    public static void bfs(int k, int x){
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        boolean [] isVisited = new boolean[lists.length + 1];
        aq1.add(x);
        isVisited[x] = true;

        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        while(!aq1.isEmpty()){
            int Qsize= aq1.size();
            cnt++;
            for(int a = 0; a < Qsize; a++){
                int now = aq1.poll();
                for(int i = 0; i < lists[now].size(); i++) {
                    int next = lists[now].get(i);
                    if(!isVisited[next]){
                        isVisited[next] = true;
                        if(cnt == k) ans.add(next);
                        aq1.add(next);
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(ans);
       for(int temp : ans){
           System.out.println(temp);
       }
    }

    public static void init(int n, int m, BufferedReader br) throws  IOException{
        lists = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
        }
    }
}