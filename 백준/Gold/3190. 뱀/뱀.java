import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 3190번 뱀
* */


public class Main {

    // 0. 정보   N      = 배열의 길이,   apples = 사과의 개수,
    //          map    = 2차원 배열,    idx,idy = 나아갈 방향
    //          snakes = 뱀이 차지하고 있는 공간
    //          nowD   = 뱀의 현재 방향
    //          snakesMovement = [index]가 초, 값이 방향
    // -------- 빈칸: 0, 사과: 1, 뱀: 2
    static int N, apples;
    static int [][] map;
    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};
    static int nowD = 1;

    static boolean isFinished = false;


    static ArrayList<int []> snakes = new ArrayList<>();

    static char [] snakesMovement = new char [10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 1. 값 입력 --------------------------------------------------------------------
        N       = Integer.parseInt(br.readLine());
        apples  = Integer.parseInt(br.readLine());

        map     = new int [N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 0);
        }

        // 1-2. 사과 입력
        for (int i = 0; i < apples; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int moveCnt = Integer.parseInt(br.readLine());

        // 1-3. 뱀의 방향전환 입력
        for (int i = 0; i < moveCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            snakesMovement[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        // 1-4. 뱀의 초기값 입력
        snakes.add(new int[]{0, 0});
        // -------------------------------------------------------------------------------
        // 실행----------------------------------------------------------------------------

        for (int i = 0; i < snakesMovement.length; i++) {




            if(snakesMovement[i] == '0') {
                moving();



                if(isFinished){
                    System.out.println(i+1);
                    return;
                }
                continue;
            }

            snakeTurnAbout(snakesMovement[i]);
            moving();

            if(isFinished){
                System.out.println(i+1);
                return;
            }


        }


    }

    // 2. 방향 전환------------------------------------------------------------------------
    public static void snakeTurnAbout (char direction) {

        switch (direction) {
            case 'D': {

                nowD = nowD == 3? 0 : nowD+1;
                break;
            }

            case 'L': {

                nowD = nowD == 0? 3 : nowD-1;
                break;
            }
        }
    }

    // 3. 자신의 몸과 부딪혔는지 확인
    public static boolean isCrashedWithBody () {

        // 앞 머리가 자신의 몸과 부딪히는지 확인
        int x = snakes.get(0)[0];
        int y = snakes.get(0)[1];


        for (int i = 1; i < snakes.size(); i++) {
            if(snakes.get(i)[0] == x && snakes.get(i)[1] == y){
                return true;
            }
        }

        return false;
        //  백준 Stream 사용이 안됨.
//          return  snakes.stream().skip(1).anyMatch(snakes -> snakes[0] == x && snakes[1] == y);
    }

    // 4. 벽과 부딪혔는지 확인
    public static boolean isCrashedWithWall () {

        // 앞 머리가 자신의 몸과 부딪히는지 확인
        int x = snakes.get(0)[0];
        int y = snakes.get(0)[1];

        return x < 0 || y < 0 || x >= N || y >= N;
    }

    // 5. 움직이기
    public static void moving () {

        int nx = snakes.get(0)[0] + idx[nowD];
        int ny = snakes.get(0)[1] + idy[nowD];

        if(nx>=0 && ny>=0 && nx < N && ny < N && map[nx][ny] == 1 ){
            ateApple(nx,ny);
            return;
        }


        snakes.add(0,new int[]{nx,ny});

        if(isCrashedWithWall() || isCrashedWithBody()){
            isFinished = true;
            return;
        }

        snakes.remove(snakes.size()-1);
    }

    // 6. 사과 먹기
    public static void ateApple(int x, int y) {

        map[x][y] = 0;
        snakes.add(0,new int[]{x,y});
    }
}
