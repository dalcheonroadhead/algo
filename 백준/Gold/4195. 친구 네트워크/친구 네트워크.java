import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static HashMap<String, Integer> converter = new HashMap<>();
    static int tc, n;
    static int [] arr;
    static int [] node_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for(int t = 0; t < tc; t++){
            n =  Integer.parseInt(br.readLine());
            int iter = 1;
            arr = new int [n*2 + 1];
            node_cnt = new int [n*2 + 1];

            for(int i = 0; i < n*2 + 1; i++){
                arr[i] = i;
                node_cnt[i] = 1;
            }

            for(int k = 0; k < n; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String former = st.nextToken();
                String latter = st.nextToken();
                if(converter.getOrDefault(former, 0) == 0) {
                    converter.put(former, iter++);
                }

                if(converter.getOrDefault(latter, 0) == 0){
                    converter.put(latter, iter++);
                }

                int a = converter.get(former);
                int b = converter.get(latter);
                int cnt = union(a,b);
                ans.append(cnt).append("\n");
            }
        }
        System.out.println(ans);
    }

    public static int union (int a, int b){
        int ancestorA = find(a);
        int ancestorB = find(b);

        if(ancestorA == ancestorB) return node_cnt[ancestorA];
        else if(ancestorA < ancestorB) {
            arr[ancestorB] = ancestorA;
            node_cnt[ancestorA] += node_cnt[ancestorB];
            return node_cnt[ancestorA];
        }else {
            arr[ancestorA] = ancestorB;
            node_cnt[ancestorB] += node_cnt[ancestorA];
            return node_cnt[ancestorB];
        }
    }

    public static int find (int a) {
        if(arr[a] == a) return a;
        arr[a] = find(arr[a]);
        return arr[a];
    }
}