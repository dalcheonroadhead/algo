import java.util.*;
import java.io.*;

public class Main {

    static int V, E, S, D;

    static class Vertex {
        int i;
        int w;

        public Vertex(int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static ArrayList<Vertex> [] lists;
    static ArrayList<Vertex> [] reverse;
    static int [] inDegree;
    static int [] critical_path;
    public static void main(String[] args) throws Exception {
        init();
        topological_sorting();
        System.out.println(critical_path[D]);
        System.out.println(dfs());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        lists = new ArrayList [V+1];
        reverse = new ArrayList [V+1];
        inDegree = new int [V+1];
        critical_path = new int [V+1];

        for(int i = 1 ; i < V+1; i++){
            lists[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            lists[start].add(new Vertex(end, weight));
            reverse[end].add(new Vertex(start, weight));
            inDegree[end]++;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }

    public static void topological_sorting() {
        ArrayDeque<Vertex> aq1 = new ArrayDeque<>();
        aq1.add(new Vertex(S, 0));
        inDegree[S] = -1; 

        while(!aq1.isEmpty()){
            Vertex now = aq1.poll();

            for(int i = 0; i < lists[now.i].size(); i++){
                Vertex next = lists[now.i].get(i);
                inDegree[next.i]--;
                critical_path[next.i] = Math.max(critical_path[next.i], critical_path[now.i] + next.w);

                if(inDegree[next.i] == 0) {
                    inDegree[next.i] = -1;
                    aq1.add(new Vertex(next.i, next.w));
                }
            }
        }
    }

    public static int dfs() {
        int cnt = 0;
        Stack<Vertex> stack = new Stack<>();
        boolean [] isVisited = new boolean[V+1];
        stack.add(new Vertex(D, 0));
        isVisited[D] = true;

        while(!stack.isEmpty()){
            Vertex now = stack.pop();

            for(int j = 0; j < reverse[now.i].size(); j++){
                Vertex next = reverse[now.i].get(j);
                if(critical_path[next.i] + next.w == critical_path[now.i]){
                    cnt++;
                    if(!isVisited[next.i]){
                        stack.add(new Vertex(next.i, next.w));
                        isVisited[next.i] = true;
                    }
                }
            }
        }
        return cnt++;
    }
}