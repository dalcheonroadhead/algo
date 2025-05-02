import java.io.*;
import java.util.*;

public class Main{

    static class Coordinate{
        int r;
        int c;
        int type;

        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }

        public Coordinate (int r, int c, int type){
            this.r = r;
            this.c = c;
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj.getClass() != this.getClass()) return false;
            Coordinate o = (Coordinate) obj;
            return o.r == this.r && o.c == this.c;
        }

        @Override
        public int hashCode() {
            return this.r* 10 + this.c;
        }
    }
    static int N,M, min = Integer.MAX_VALUE;
    static int [][] field;
    static int [][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}}; //  상하좌우
    static ArrayList<Coordinate> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        permutation(new int[list.size()], 0);
        System.out.println(min);
    }

    public static void init() throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] != 0 && field[i][j] != 6) {
                    list.add(new Coordinate(i,j, field[i][j]));
                }
            }
        }
    }

    public static void permutation (int [] nums, int depth ){
        if(depth == list.size()){
            int [][] map = new int [N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = field[i][j];
                }
            }
            for (int i = 0; i < list.size(); i++) {
                switch (list.get(i).type){
                    case 1: {
                        cctv1(nums[i], map,list.get(i));
                        break;
                    }
                    case 2:{
                        cctv2(nums[i], map, list.get(i));
                        break;
                    }
                    case 3: {
                        cctv3(nums[i], map, list.get(i));
                        break;
                    }
                    case 4: {
                        cctv4(nums[i], map,list.get(i));
                        break;
                    }
                    case 5: {
                        cctv5(map, list.get(i));
                        break;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }
        Coordinate now = list.get(depth);
        int type = field[now.r][now.c];
        int max = type == 5? 1 :
            type == 2? 2: 4;

        for (int i = 0; i < max; i++) {
            nums[depth] = i;
            permutation(nums, depth+1);
        }
    }





    static void cctv1(int d, int [][] map, Coordinate coordinate) {
        int nextR = coordinate.r;
        int nextC = coordinate.c;
        visit(d,map, nextR, nextC,1);
    }

    static void cctv2(int d, int[][] map, Coordinate coordinate) {
        int nextR = coordinate.r;
        int nextC = coordinate.c;
        if(d == 0) { // 좌우
            visit(2,map, nextR, nextC,2);
            nextR = coordinate.r;;
            nextC = coordinate.c;
            visit(3, map, nextR, nextC,2);
        }else if (d == 1) { // 상하
            visit(0,map, nextR, nextC,2);
            nextR = coordinate.r;
            nextC = coordinate.c;
            visit(1, map, nextR, nextC,2);
        }
    }

    static void cctv3(int d, int[][] map, Coordinate coordinate){
        int nextR = coordinate.r;
        int nextC = coordinate.c;
        switch (d){ // 각각 90도씩
            case 0: {
                visit(0, map, nextR, nextC,3);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(3, map, nextR, nextC,3);
                break;
            }
            case 1:{
                visit(0, map, nextR, nextC,3);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(2, map, nextR, nextC,3);
                break;
            }
            case 2: {
                visit(1, map, nextR, nextC,3);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(2, map, nextR, nextC,3);
                break;
            }
            case 3:{
                visit(1, map, nextR, nextC,3);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(3, map, nextR, nextC,3);
            }
        }
    }
    static void cctv4(int d, int [][] map, Coordinate coordinate){
        int nextR = coordinate.r;
        int nextC = coordinate.c;
        switch (d){
            case 0: { // 좌상우
                visit(0, map, nextR, nextC, 4); // 상
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(2, map, nextR,nextC, 4);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(3, map, nextR,nextC, 4);
                break;
            }
            case 1: { // 상, 하, 좌
                visit(0, map, nextR, nextC, 4); // 상
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(1, map, nextR,nextC, 4);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(2, map, nextR,nextC, 4);
                break;
            }
            case 2: { // 상,하,우
                visit(0, map, nextR, nextC, 4); // 상
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(1, map, nextR,nextC, 4);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(3, map, nextR,nextC, 4);
                break;
            }
            case 3: { // 하,좌,우
                visit(1, map, nextR, nextC, 4); // 상
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(2, map, nextR,nextC, 4);
                nextR = coordinate.r;
                nextC = coordinate.c;
                visit(3, map, nextR,nextC, 4);
                break;
            }

        }
    }

    static void cctv5(int[][] map, Coordinate coordinate){
        int nextR = coordinate.r;
        int nextC = coordinate.c;
        visit(0, map, nextR, nextC,5);
        nextR = coordinate.r;
        nextC = coordinate.c;
        visit(1, map, nextR, nextC,5);
        nextR = coordinate.r;
        nextC = coordinate.c;
        visit(2, map, nextR, nextC,5);
        nextR = coordinate.r;
        nextC = coordinate.c;
        visit(3, map, nextR, nextC,5);
    }

    public static void visit (int d, int [][] map, int nextR, int nextC, int type) {
        while (!OOB(nextR, nextC)){
            if( map[nextR][nextC] == 6) break;
            map[nextR][nextC] = type;
            nextR += dir[d][0];
            nextC += dir[d][1];
        }
    }

    public static boolean OOB(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}