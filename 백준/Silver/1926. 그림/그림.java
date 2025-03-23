import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int R, C;
    static int [][] drawings;
    static int [][] dir = new int [][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    static class Coordinate {
        int r, c;

        public Coordinate (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        drawings = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                drawings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++) {
                if(drawings[i][j] == 1){
                    max = Math.max(max, bfs(i,j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    public static int bfs (int r, int c) {
        int ans = 1;
        Coordinate start = new Coordinate(r,c);
        drawings[r][c] = 2;
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        aq1.add(start);
        while(!aq1.isEmpty()) {
            Coordinate now = aq1.poll();
                for (int i = 0; i < 4; i++) {
                    int next_r = now.r + dir[i][0];
                    int next_c = now.c + dir[i][1];
                    if(!OOB(next_r, next_c) && drawings[next_r][next_c] == 1) {
                        ans++;
                        drawings[next_r][next_c] = 2;
                        aq1.add(new Coordinate(next_r,next_c));
                    }
                }
        }
        return  ans;
    }

    public static boolean OOB(int r, int c){
        return (r < 0 || r >= R || c < 0 || c >= C);
    }
}