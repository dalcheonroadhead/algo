import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int [n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right= Integer.parseInt(st.nextToken());

            if(union(left, right)) {
                System.out.println(i);
                return;}

        }
        System.out.println(0);
    }


    public static boolean union(int a, int b) {
        int ancestorA = find(a);
        int ancestorB = find(b);

        if(ancestorA == ancestorB) return true;
        else if (ancestorA < ancestorB) {
            parents[ancestorB] = ancestorA;
        }else {
            parents[ancestorA] = ancestorB;
        }
        return false;
    }

    public static int find (int a){
        if(parents[a] == a) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }
}