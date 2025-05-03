import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static ArrayList<Integer> [] lists;
    static int [] inDegree;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        topologicalSorting();
        for(int temp : ans){
            System.out.print(temp + " ");
        }
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
        while(ans.size() < N){
            int now = 0;
            for (int i = 1; i < N+1; i++) {
                if(inDegree[i] == 0) {
                    inDegree[i]--;
                    now = i;
                    break;
                }
            }
            ans.add(now);
            for (int i = 0; i < lists[now].size(); i++) {
                inDegree[lists[now].get(i)]--;
            }
        }
    }
}
