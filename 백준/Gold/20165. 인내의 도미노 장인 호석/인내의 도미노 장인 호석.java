import java.io.*;
import java.util.*;


public class Main {
    static class Turn {
        int atkR;
        int atkC;
        int dir;
        int defR;
        int defC;
    }
    static class Coordinate {
        int r;
        int c;

        public Coordinate (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int [][] dir = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int [][] board;
    static boolean [][] isFall;
    static Turn [] turns;
    static int R,C, round;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        input();

        for(int i = 0; i < turns.length;i++){
            attack(i);
            defense(i);
        }
        print();
    }

    public static void print (){
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer.append(isFall[i][j]? 'F' : 'S').append(" ");
            }
            answer.append("\n");
        }
        System.out.println(sum);
        System.out.println(answer);
    }

    // bfs
    public static void attack (int turn) {
        Turn now = turns[turn];
        // 공격
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        if(isFall[now.atkR][now.atkC]) return; // 시작점이 이미 떨군 곳이면 넘어가기
        isFall[now.atkR][now.atkC] = true;
        int cnt = 1; // 넘어진 값의 개수
        if(board[now.atkR][now.atkC] == 1) {
            sum += cnt;
            return;  // 자기 자신만 떨어지는 지점이면 넘어가기
        }
        aq1.add(new Coordinate(now.atkR + dir[now.dir][0], now.atkC + dir[now.dir][1]));
        int remain_fall = board[now.atkR][now.atkC] - 1; // 앞으로 넘어질 도미노의 개수


        while(!aq1.isEmpty()){
            Coordinate cur = aq1.poll();
            // OOB이면 끝내기
            if(OOB(cur.r, cur.c)) break;

            // 현 block이 넘어지지 않았다. -> 넘어뜨리기, 앞으로 넘어질 도미노 개수 깎기
            remain_fall--;
            // 금방 넘어진 녀석이 넘어뜨릴 수 있는 값의 개수와 기존의 앞으로 넘어질 도미노 개수 비교해서 최대값 갱신
            if(!isFall[cur.r][cur.c]){
                isFall[cur.r][cur.c] = true;
                cnt++;
                remain_fall = Math.max(board[cur.r][cur.c]-1, remain_fall);
            }

            // 넘어져야할 보드 수가 아직 0이 아니다. -> 현 block이 쓰러졌든 아니든 무조건 다음 block 넣기
            if(remain_fall > 0) aq1.add(new Coordinate(cur.r + dir[now.dir][0], cur.c+dir[now.dir][1]));
        }

        sum += cnt;
    }

    public static void defense (int turn){
        Turn now = turns[turn];
        isFall[now.defR][now.defC] = false;
    }
    public static boolean OOB (int r, int c) {
        return  r < 0 || c < 0 || r >= R || c >= C;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        round = Integer.parseInt(st.nextToken());
        board = new int [R][C];
        isFall = new boolean[R][C];
        turns = new Turn[round];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < round; i++){
            Turn t = new Turn();
            st = new StringTokenizer(br.readLine());
            t.atkR = Integer.parseInt(st.nextToken())-1;
            t.atkC = Integer.parseInt(st.nextToken())-1;
            char way = st.nextToken().charAt(0);
            t.dir = (way == 'E')? 0 :(way =='W')? 1 : (way =='S')? 2 : (way == 'N')? 3 : -99999999;
            st = new StringTokenizer(br.readLine());
            t.defR = Integer.parseInt(st.nextToken())-1;
            t.defC = Integer.parseInt(st.nextToken())-1;
            turns[i] = t;
        }
    }
}