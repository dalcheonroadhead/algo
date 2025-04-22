import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int G, P;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parents = new int [G+1];
        for(int i = 1; i <= G; i++){
            parents[i] = i;
        }

        int ans = 0;
        for(int i = 1; i <= P; i++) {
            int docking = Integer.parseInt(br.readLine());
            int destination = find(docking);
            if(destination == 0) break;
            else {
                ans++;
                union(destination-1, destination);
            }
        }
        System.out.println(ans);
    }

    public static void union(int a, int b){
        int ancestorA = find(a);
        int ancestorB = find(b);

        if(ancestorA == ancestorB) return;
        else if(ancestorA < ancestorB) {
            parents[ancestorB] = ancestorA;
        }else {
            parents[ancestorA] = ancestorB;
        }
    }

    public static int find (int gate_num) {
        if(parents[gate_num] == gate_num) return gate_num;
        parents[gate_num] = find(parents[gate_num]);
        return parents[gate_num];
    }
}