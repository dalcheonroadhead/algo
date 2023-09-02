import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 목표 지점에서 부터 queue 를 이용해 bfs 돌려서 배열 해당 자리에 최단 거리를 저장한다. */

public class Main {

    static int N,M, goalX, goalY;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    static int [][] arr;
    static boolean [][] flag;

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        flag = new boolean[N][M];

        // 값 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = (temp  == 1? -1 : temp);

                if(arr[i][j] == 2){
                    goalX = i;
                    goalY = j;
                }
            }
        }

        bfs(goalX, goalY);

        for (int[] temp :
                arr) {
            for (int a :
                    temp) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int goalX, int goalY) {
        ArrayDeque<Coordinate> q1 = new ArrayDeque<>();
        q1.add(new Coordinate(goalX, goalY));

        arr[goalX][goalY] = 0;

        flag[goalX][goalY] = true;

        int nowDistance = 1;
        while(!q1.isEmpty()){

            int Qsize = q1.size();

            for (int i = 0; i < Qsize; i++) {
                Coordinate cur = q1.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + idx[j];
                    int ny = cur.y + idy[j];

                    if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny] != 0){

                        if(flag[nx][ny]) continue;

                        arr[nx][ny] = nowDistance;
                        flag[nx][ny] = true;
                        q1.add(new Coordinate(nx,ny));
                    }
                }
            }
            nowDistance++;
        }


    }

}

class Coordinate{
    int x;
    int y;

    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}