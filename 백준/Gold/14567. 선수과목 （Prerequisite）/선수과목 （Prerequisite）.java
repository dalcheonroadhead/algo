import java.util.*;
import java.io.*;

// 14567 선수과목
public class Main {
    static int V,E;
    static int [] degrees;
    static int [] semesters;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }
        degrees = new int [V+1];
        semesters = new int[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists.get(start).add(end);
            degrees[end]++;
        }
        topological_sort();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < V+1; i++) {
            ans.append(semesters[i]).append(" ");
        }
        System.out.println(ans);
    }

    public static void topological_sort () {
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        for (int i = 1; i < V+1; i++) {
            if(degrees[i] == 0) {
                aq1.add(i);
                semesters[i] = 1;
            }
        }
        while(!aq1.isEmpty()){
            int start = aq1.poll();
            for (int i = 0; i < lists.get(start).size(); i++) {
                int dest = lists.get(start).get(i);
                degrees[dest]--;
                semesters[dest] = Math.max(semesters[dest], semesters[start] + 1);
                if(degrees[dest] == 0) aq1.add(dest);
            }
        }
    }
}