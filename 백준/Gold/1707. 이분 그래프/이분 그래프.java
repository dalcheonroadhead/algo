import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer> [] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t = 0; t < TC; t++) {
            init(br);
            System.out.println(bfs()? "YES" : "NO");
        }

    }

    public static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        lists = new ArrayList[V+1];

        for(int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }
    }

    public static boolean bfs () {
        char [] color = new char[lists.length];
        Arrays.fill(color, '_');
        for(int i = 1; i < lists.length; i++){
            if(color[i] == '_') {
                boolean now = isBinaryGraph(i, color);
                if(!now) return  false;
            }
        }
        return true;
    }

    public static boolean isBinaryGraph(int start, char [] color) {
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        color[start] = 'R';
        aq1.add(start);

        while(!aq1.isEmpty()){
            int now = aq1.poll();
            for(int i = 0; i < lists[now].size(); i++){
                int next = lists[now].get(i);
                if(color[next] == color[now]) return false;
                else if(color[next] == '_') {
                    color[next] = color[now] == 'R'? 'C' : 'R';
                    aq1.add(next);
                }else continue;
            }
        }
        return true;
    }
}