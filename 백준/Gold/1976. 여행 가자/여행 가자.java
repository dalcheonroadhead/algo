import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int [n+1];

        for(int i = 0; i < n+1; i++){
            arr[i] = i;
        }

        for(int i = 1; i <= n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ancestor = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < m; i++){
            if (find(Integer.parseInt(st.nextToken())) != ancestor) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        int ancestorA = find(a);
        int ancestorB = find(b);
        if(ancestorA == ancestorB) return;
        else if(ancestorA < ancestorB) arr[ancestorB] = ancestorA;
        else arr[ancestorA] = ancestorB;
    }

    public static int find (int a) {
        if(arr[a] == a) return  a;

        int ans = find(arr[a]);
        arr[a] = ans;
        return ans;
    }
}