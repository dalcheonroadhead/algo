import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int R, C;
    static char [][] field;
    static boolean [][] isVisited;
    static int [][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static ArrayDeque<Coordinate> melting_spot = new ArrayDeque<>();
    static ArrayDeque<Coordinate> swan_1 = new ArrayDeque<>();


    static class Coordinate {
        int r;
        int c;

        public Coordinate (int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int cnt = 0;
        while (true) {
            cnt++;
            melting();
            if(swan_fill(true)) break;
        }
        System.out.println(cnt);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][C];
        isVisited = new boolean[R][C];
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = row.charAt(j);
                if(row.charAt(j) != 'X') melting_spot.add(new Coordinate(i,j));
                if(row.charAt(j) == 'L') {
                    if(cnt == 0) {
                        field[i][j] = '1';
                        swan_1.add(new Coordinate(i,j));
                    }
                    else field[i][j] ='2';
                    cnt++;
                }
            }
        }
    }

    public static void melting() {
        int qSize = melting_spot.size();
        for (int i = 0; i < qSize; i++) {
            Coordinate now = melting_spot.poll();
            for (int j = 0; j < 4; j++) {
                int nextR = now.r + dir[j][0];
                int nextC = now.c + dir[j][1];
                if(!OOB(nextR,nextC) && field[nextR][nextC] == 'X'){
                    field[nextR][nextC] = '.';
                    melting_spot.add(new Coordinate(nextR, nextC));
                }
            }
        }
    }

    public static boolean swan_fill(boolean isOne) {
        char fill = '1';
        char opposite ='2';
        ArrayDeque<Coordinate> now_aq1 = swan_1;
        ArrayDeque<Coordinate> next_aq = new ArrayDeque<>();

        while (!now_aq1.isEmpty()) {
            Coordinate now = now_aq1.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dir[i][0];
                int nextC = now.c + dir[i][1];
                if(!OOB(nextR,nextC)&& !isVisited[nextR][nextC] &&field[nextR][nextC] != 'X') {
                    if(field[nextR][nextC] != opposite){
                        field[nextR][nextC] = fill;
                        isVisited[nextR][nextC] = true;
                        now_aq1.add(new Coordinate(nextR,nextC));
                    }else {
                        return true;
                    }
                }
                if ((!OOB(nextR,nextC)&& !isVisited[nextR][nextC] &&field[nextR][nextC] == 'X')){
                    isVisited[nextR][nextC] = true;
                    next_aq.add(new Coordinate(nextR,nextC));
                }
            }
        }
        swan_1 = next_aq;
        return false;
    }

    public static boolean OOB (int r, int c) {
        return !(r >= 0 && r < R && c >= 0 && c < C);
    }
}