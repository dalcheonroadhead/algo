import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int [] dist;
    static int [] flag; // 0 = no visited, 1 = visited, 2 = invalid;
    public static void main(String[] args) throws IOException {
        int tc = 0;
//        System.setIn(new FileInputStream("src/testcase/tc4803.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            tc++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            dist = new int [N+1];
            flag = new int [N+1];
            for(int i = 0; i < N+1; i++){
                dist[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            int cnt = 0;
            for (int i = N; i > 0; i--) {
                if(flag[i] == 0) {
                    int ancestor = find(i);
                    if(flag[ancestor] == 0) {
                        cnt++;
                        flag[ancestor] = 1;
                    }
                }
            }
            switch (cnt) {
                case 0:
                    System.out.println("Case "+tc+": No trees.");
                    break;
                case 1:
                    System.out.println("Case "+tc+": There is one tree.");
                    break;
                default:
                    System.out.println("Case "+tc+": A forest of "+ cnt + " trees.");
            }
        }
    }

    public static void union(int a, int b) {
        int ancestorA = find(a);
        int ancestorB = find(b);

        if(ancestorA == ancestorB || flag[ancestorA] == 2 || flag[ancestorB] == 2) {
            checkInvalid(ancestorA);
            checkInvalid(ancestorB);
        }else if(ancestorA < ancestorB){
            dist[ancestorB] = ancestorA;
        }else {
            dist[ancestorA] = ancestorB;
        }
    }

    public static int find(int i){
        if(dist[i] == i) return i;
        dist[i] = find(dist[i]);
        return dist[i];
    }

    public static void checkInvalid(int ancestor){
        for (int i = 1; i < N+1; i++) {
            if(find(i) == ancestor) flag[i] = 2;
        }
    }
}