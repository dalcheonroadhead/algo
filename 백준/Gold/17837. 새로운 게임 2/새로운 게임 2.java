import java.io.*;
import java.util.*;


public class Main {

    static class Horse {
        int r;
        int c;
        int dir;

        public Horse (int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    static HashMap<Integer, Horse> horse = new HashMap<>();
    static ArrayList<Integer> [][] stack; // index = 0 이 맨 아래, 그 이후로부터 쌓아올라감.
    static int [][] map; // 0 = 흰색, 1 = 빨간색, 2 = 파란색
    static int [][] dir = new int [][] {{-999, -999}, {0,1}, {0,-1}, {-1,0}, {1,0}};
    static int N, K;
    public static void main(String[] args) throws IOException {
        init();

        int cnt = 1;
        while(cnt <= 1_000){
            for(int i  = 0; i < K; i++){
                move(i);
                Horse now = horse.get(i);
                if(stack[now.r][now.c].size() >= 4) {
                    System.out.println(cnt);
                    return;
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }

    // 움직이려는 말의 다음 위치가 흰색인지, 빨간색인지, 파란색 or 장외인지 확인 후 적절한 움직임으로 이동
    public static void move(int index) {
        Horse now = horse.get(index);
        int nextR = now.r + dir[now.dir][0];
        int nextC = now.c + dir[now.dir][1];
        if(OOB(nextR, nextC)) goBlue(now.r, now.c, index);
        else switch (map[nextR][nextC]){
            case 0: {
                goWhite(now.r, now.c, index);
                break;
            }
            case 1: {
                goRed(now.r, now.c, index);
                break;
            }
            default: goBlue(now.r, now.c, index);
        }
    }

    public static void goWhite(int r, int c, int index) {
        Horse origin = horse.get(index);
        ArrayList<Integer> now = stack[r][c];
        ArrayList<Integer> temp = new ArrayList<>();
        int peek = now.size()-1;

        // stack 상 위에 것들 먼저 좌표 옮기기
        while(now.get(peek) != index){
            int idx = now.get(peek);
            Horse h = horse.get(idx);
            h.r += dir[origin.dir][0];
            h.c += dir[origin.dir][1];
            temp.add(idx);
            now.remove(peek--);
        }
        // 내가 움직이려는 말 좌표 옮기기
        origin.r += dir[origin.dir][0];
        origin.c += dir[origin.dir][1];
        temp.add(index);
        now.remove(peek);

        // stack에 쌓기
        for(int i = temp.size()-1; i >= 0; i--){
            stack[origin.r][origin.c].add(temp.get(i));
        }
    }

    public static void goRed(int r, int c, int index) {
        Horse origin = horse.get(index);
        origin.r += dir[origin.dir][0];
        origin.c += dir[origin.dir][1];
        ArrayList<Integer> now = stack[r][c];
        int peek = now.size()-1;

        // stack 상 위에 것들 먼저 좌표 옮기기
        while(now.get(peek) != index){
            int idx = now.get(peek);
            Horse h = horse.get(idx);
            h.r += dir[origin.dir][0];
            h.c += dir[origin.dir][1];
            // stack에 바로 넣어야 반대로 들어감.
            stack[origin.r][origin.c].add(idx);
            now.remove(peek--);
        }
        // 내가 움직이려는 말 좌표 옮기기
        now.remove(peek);
        stack[origin.r][origin.c].add(index);
    }

    public static void goBlue(int r, int c, int index) {
        // 방향 바꾸기
        Horse origin = horse.get(index);
        origin.dir = (origin.dir == 1)? 2
            : (origin.dir == 2)? 1
                : (origin.dir == 3)? 4
                    : (origin.dir == 4)? 3 : 0;

        // 방향 바꿨는데도 다음 한 칸이 blue나 OOB인지 확인
        int nextR = origin.r + dir[origin.dir][0];
        int nextC = origin.c + dir[origin.dir][1];

        // 맞으면 가만히 서있기
        if(OOB(nextR, nextC) || map[nextR][nextC] == 2) return;
        // 아니면 이동
        if(map[nextR][nextC] == 0) goWhite(r, c, index);
        if(map[nextR][nextC] == 1) goRed(r, c, index);
    }

    public static boolean OOB (int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int [N][N];
        stack = new ArrayList[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                stack[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            horse.put(i, new Horse(r, c, dir));
            stack[r][c].add(i);
        }
    }
}