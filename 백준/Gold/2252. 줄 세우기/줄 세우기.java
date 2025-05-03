import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static ArrayList<Integer> [] lists;
    static int [] inDegree;
    public static void main(String[] args) throws IOException {
        init();
        topologicalSorting();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists= new ArrayList [N+1];
        inDegree = new int [N+1];
        for (int i = 1; i < N+1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lists[A].add(B);
            inDegree[B]++;
        }
    }
    public static void topologicalSorting(){
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(inDegree[i] == 0) {
                aq1.add(i);
                ans.append(i).append(" ");
            }
        }
        while (!aq1.isEmpty()){
            int now = aq1.poll();
            for (int i = 0; i < lists[now].size(); i++) {
                int next = lists[now].get(i);
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    aq1.add(next);
                    ans.append(next).append(" ");
                }
            }
        }
        System.out.println(ans);
    }
}