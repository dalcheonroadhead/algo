import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int [][] miro;
    static int [] idx = new int[] {-1,0,1,0};
    static int [] idy = new int[] {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int [N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        bfs(0,0);
        System.out.println(miro[N-1][M-1]);
    }

    public static void bfs(int startX, int startY){
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate(startX, startY));
        miro[startX][startY] = -1;              // 방문 처리
        int cnt = 1;
        while (!aq1.isEmpty()){
            cnt++;
            int Qsize = aq1.size();
            for (int k = 0; k < Qsize; k++) {
                Coordinate now = aq1.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + idx[i];
                    int ny = now.y + idy[i];
                    if(nx>=0 && ny>=0 && nx < N && ny < M){
                        if(miro[nx][ny] == 1){
                            miro[nx][ny] = cnt;
                            aq1.add(new Coordinate(nx,ny));
                        }
                    }
                }
            }
        }
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate (int x, int y){
        this.x = x;
        this.y = y;
    }
}