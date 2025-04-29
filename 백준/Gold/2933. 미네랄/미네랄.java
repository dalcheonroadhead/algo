import java.io.*;
import java.util.*;

public class Main{
    static int R, C, N;
    static char [][] cave;
    static boolean [][] isVisited;
    static int [] height;
    static int [][] dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static class Coordinate {
        int r;
        int c;

        Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < height.length; i++) {
            remove(i, height[i]);
            checkConnected();
            fallDown();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(cave[i][j]);
            }
            System.out.println();
        }

    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new char[R][C];

        for (char [] temp : cave){
            Arrays.fill(temp, '.');
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                cave[i][j] = row.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        height = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = R - Integer.parseInt(st.nextToken());
        }
    }

    private static void remove (int turn, int height) {
        if(turn %2 == 0){
            for (int i = 0; i < C; i++) {
                if(cave[height][i] == 'x') {
                    cave[height][i] = '.';
                    return;
                }
            }
        }else {
            for (int i = C-1; i >= 0; i--) {
                if(cave[height][i] == 'x') {
                    cave[height][i] = '.';
                    return;
                }
            }
        }
    }

    private static void checkConnected() {
        isVisited = new boolean[R][C];
        for (int l = 0; l < C; l++) {
            if(cave[R-1][l] == 'x' && !isVisited[R-1][l]){
                Coordinate start = new Coordinate(R-1, l);
                ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
                isVisited[start.r][start.c] = true;
                aq1.add(start);

                while(!aq1.isEmpty()){
                    Coordinate now = aq1.poll();
                    for (int i = 0; i < 4; i++) {
                        int nextR = now.r + dir[i][0];
                        int nextC = now.c + dir[i][1];
                        if(IB(nextR, nextC) && !isVisited[nextR][nextC] && cave[nextR][nextC] == 'x'){
                            isVisited[nextR][nextC] = true;
                            aq1.add(new Coordinate(nextR, nextC));
                        }
                    }
                }
            }
        }
    }

    public static void fallDown() {
        ArrayList<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(cave[i][j] == 'x' && !isVisited[i][j]){
                    cave[i][j] = '.';
                    list.add(new Coordinate(i,j));
                }
            }
        }
        if(list.isEmpty()) return;

        boolean down = true;
        while(down) {
            for (Coordinate now : list){
                if(!IB(now.r+1, now.c)||cave[now.r+1][now.c] =='x') {
                    down = false;
                    break;
                }
            }
            if(down){
                for (Coordinate now : list){
                    now.r++;
                }
            }
        }

        for (Coordinate now : list){
            cave[now.r][now.c] = 'x';
        }
    }



    private static boolean IB(int r, int c) {
        return (r >= 0 && c>= 0 && r<R && c <C);
    }
}
