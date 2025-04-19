import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n,m;
    static int [] tree;
    static int [][] order;
    static int [] list;
    public static void main(String[] args) throws IOException {
        init();
        executingOrder();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int [n+1];
        order = new int [m][3];
        for(int i = 0; i < n+1; i++){
            tree[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
            order[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    public static void executingOrder() {
        for (int i = 0; i < m; i++) {
            if (order[i][0] == 0)
                union(order[i][1], order[i][2]);
            else System.out.println(find(order[i][1]) == find(order[i][2])? "YES" : "NO");

        }
    }

    public static void union (int a, int b) {
        int ancestorA = find(a);
        int ancestorB = find(b);
        if(ancestorA == ancestorB) return;
        else if(ancestorA < ancestorB) tree[ancestorB] = ancestorA;
        else tree[ancestorA] = ancestorB;
    }

    public static int find (int start) {
        // base case
        if(start == tree[start]) return start;
        // calculation - path compression
        tree[start] = find(tree[start]);
        return tree[start];
    }
}