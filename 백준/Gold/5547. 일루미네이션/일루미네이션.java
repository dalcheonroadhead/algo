import java.io.*;
import java.util.*;

public class Main {
    static int [][] forEven = new int[][]{{-1,-1}, {-1,0}, {0,1}, {1,0}, {1,-1}, {0,-1}};
    static int [][] forOdd  = new int[][]{{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {0,-1}};
    static int paint = 0;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int [][] map = new int[row+2][col+2];

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map, 0,0);
        System.out.println(paint);
    }

    public static void bfs(int [][] map, int x, int y) {
        // 미방문 길: 0, 건물:1, 방문 길 2
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate(x,y));
        map[x][y] = 2;
        while (!aq1.isEmpty()){
            Coordinate now = aq1.poll();
            int [][] direction = (now.row%2 == 0? forEven : forOdd);
            int cnt = 0;
            // 현재 위치에서 6방 검색
            for (int i = 0; i < direction.length; i++) {
                int nRow = now.row + direction[i][0];
                int nCol = now.col + direction[i][1];
                if(nRow >= 0 && nRow < map.length && nCol >= 0 && nCol < map[0].length){
                    if(map[nRow][nCol] == 1) cnt++;
                    else if (map[nRow][nCol] == 0) {
                        map[nRow][nCol] = 2;
                        aq1.add(new Coordinate(nRow,nCol));
                    }
                }
            }
            paint += cnt;
        }
    }
}
class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }
}