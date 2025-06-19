import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static int answer = Integer.MAX_VALUE;
    static boolean [][][][] check;
    static char [][] board;
    static int [][] dir = new int [][] {{0,1},{0,-1},{1,0},{-1,0}}; // 동,서,남,북
    static class Bead {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Bead() {
            this.cnt = 0;
        };

        public Bead(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = 0;
        };

        public Bead(int rx, int ry, int bx, int by, int cnt){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char [R][C];
        Bead start = new Bead();

        for(int i = 0; i < R; i++){
            String row = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = row.charAt(j);
                if(board[i][j] == 'R') {start.rx = i; start.ry = j;}
                if(board[i][j] == 'B') {start.bx = i; start.by = j;}
            }
        }
        bfs(start);
        System.out.println(answer>10? -1 : answer);
    }

    public static void bfs(Bead start) {
        ArrayDeque<Bead> aq1 = new ArrayDeque<>();
        check = new boolean [R][C][R][C];
        check[start.rx][start.ry][start.bx][start.by] = true;
        aq1.add(start);

        while(!aq1.isEmpty()){
            Bead now = aq1.poll();
            LOOP:
            for(int i = 0; i < 4; i++){
                int nrx = now.rx;
                int nry = now.ry;
                int nbx = now.bx;
                int nby = now.by;

                int dx = dir[i][0];
                int dy = dir[i][1];

                while(!OOB(nbx+dx, nby+dy)){
                    nbx += dx; 
                    nby += dy;
                    if(board[nbx][nby] == 'O') continue LOOP;
                }

                while(!OOB(nrx+dx, nry+dy)){
                    nrx += dx; 
                    nry += dy;
                    if(board[nrx][nry] == 'O') {
                        answer = Math.min(answer, now.cnt+1);
                        return;
                    }
                }

                if(nrx == nbx && nry == nby) {
                    switch (i){
                        case 0: {
                            if(now.ry < now.by) nry -= 1;
                            else nby -= 1;
                            break;
                        }
                        case 1: {
                            if(now.ry < now.by) nby += 1;
                            else nry += 1;
                            break;
                        }
                        case 2: {
                            if(now.rx < now.bx) nrx -= 1;
                            else nbx -= 1;
                            break;
                        }
                        case 3: {
                            if(now.rx < now.bx) nbx += 1;
                            else nrx += 1;
                            break;
                        }
                    }
                }
                if(check[nrx][nry][nbx][nby]) continue;
                check[nrx][nry][nbx][nby] = true;
                aq1.add(new Bead(nrx, nry, nbx, nby, now.cnt+1));
            }
        }
    }

    private static boolean OOB(int r, int c){
        return r < 0 || c < 0 || r >= R || c >= C || board[r][c] == '#';
    }
}