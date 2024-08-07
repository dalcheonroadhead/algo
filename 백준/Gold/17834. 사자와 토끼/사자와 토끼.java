import java.io.*;
import java.util.*;

public class Main {
    // 인접 리스트
    static ArrayList<Integer> [] lists;
    static char [] vertex_color;
    static char [] color = new char[]{'B','W'};
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        vertex_color = new char[N+1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }

        if (!bfs(1)) {
            System.out.println(0);
        }else {
            int cnt = 0;
            int Bcnt = 0;
            int Wcnt = 0;
            for (int i = 1; i < vertex_color.length; i++) {
                if(vertex_color[i] == 'B') Bcnt++;
                else Wcnt++;
            }
            cnt += Bcnt*Wcnt*2;
            System.out.println(cnt);
        }
    }

    public static boolean bfs(int start) {
        int value = 0;
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(start);
        vertex_color[start] = color[toggle(value)];

        while (!aq1.isEmpty()){
            int Qsize = aq1.size();
            value++;
            for (int i = 0; i < Qsize; i++) {
                int now = aq1.poll();
                for (int j = 0; j < lists[now].size(); j++) {
                    int next = lists[now].get(j);
                    if(vertex_color[next] == '\u0000') {
                        vertex_color[next] = color[toggle(value)];
                        aq1.add(next);
                    }else if(vertex_color[next] == vertex_color[now]) return false;

                }
            }
        }
        return true;
    }

    public static int toggle (int value) {
        return value%2;
    }
}