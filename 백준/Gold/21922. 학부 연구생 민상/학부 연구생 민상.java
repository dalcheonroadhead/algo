import java.io.*;
import java.util.*;


public class Main {
    static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int [][] dir = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int [][] map;
    static boolean [][] isWind;
    static int R,C;
    static ArrayList<Coordinate> air_conditions;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        for (Coordinate airCondition : air_conditions) {
            bfs(airCondition);
        }
        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if(isWind[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }

    public static void bfs(Coordinate start) {
        for (int i = 0; i < 4; i++) {
            Coordinate now = new Coordinate(start.r, start.c);
            isWind[start.r][start.c] = true;
            int direction = i;
            while (true){
                now.r += dir[direction][0];
                now.c += dir[direction][1];
                if(OOB(now.r, now.c)) break;
                if(now.r == start.r && now.c == start.c) break;
                isWind[now.r][now.c] = true;
                switch (map[now.r][now.c]){
                    case 1: {
                        direction = o1(direction);
                        break;
                    }
                    case 2: {
                        direction = o2(direction);
                        break;
                    }
                    case 3: {
                        direction = o3(direction);
                        break;
                    }
                    case 4: {
                        direction = o4(direction);
                        break;
                    }
                }
            }
        }
    }

    public static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 9) {
                    System.out.printf("%c ", 'O');
                    continue;
                }
                System.out.printf("%c ", isWind[i][j]? 'T' : 'F');
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int o1(int inputDir) {
        switch (inputDir) {
            case 0: return  1;
            case 1: return 0;
            default: return inputDir;
        }
    }

    public static int o2(int inputDir) {
        switch (inputDir) {
            case 2: return  3;
            case 3: return 2;
            default: return inputDir;
        }
    }

    public static int o3 (int inputDir){
        switch (inputDir) {
            case 0: return  3;
            case 1: return  2;
            case 2: return 1;
            case 3: return 0;
            default: return -99999;
        }
    }

    public static int o4(int inputDir) {
        switch (inputDir) {
            case 0: return  2;
            case 1: return  3;
            case 2: return  0;
            case 3: return 1;
            default: return -9999;
        }
    }

    public static boolean OOB (int r, int c){
        return r < 0 || c < 0 || r >= R || c >= C;
    }


    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isWind = new boolean[R][C];
        air_conditions = new ArrayList<>();
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) air_conditions.add(new Coordinate(i,j));
            }
        }
    }
}