import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int [][][] boards = new int [5][19][19]; // 0 - 원본, 1 - 가로, 2 - 세로, 3 - 우밑 대각, 4 - 우상 대각
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                boards[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 19; j++) {
                System.arraycopy(boards[0][j],0, boards[i][j], 0, 19);
            }
        }
        int ans = 0;
        int ans_x = 0; int ans_y = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(boards[0][i][j] == 1 || boards[0][i][j] == 2){
                    int stone_num = boards[0][i][j];
                    if(horizontal(i,j,0,stone_num) || vertical(i,j,0,stone_num)
                        || diagonal_row(i,j,0,stone_num) || diagonal_high(i,j,0,stone_num)){
                        ans = stone_num; ans_x = i+1; ans_y = j+1;
                    }
                }
            }
        }
        System.out.println(ans + (ans != 0? ("\n"+ans_x+" "+ans_y) : ""));

    }

    public static boolean horizontal(int x, int y, int depth, int stone_num){
        if(depth == 5){
            if(OOB(x,y)) return true;
            else if(boards[1][x][y] != stone_num) return true;
            else Arrays.fill(boards[1][x], -1);
            return false;
        }

        if(OOB(x,y)) return false;
        else if(boards[1][x][y] == stone_num) return horizontal(x,y+1, depth+1, stone_num);
        else return false;
    }

    //---------------------------------------------------------------------------------------

    public static boolean vertical(int x, int y, int depth, int stone_num){
        if(depth == 5){
            if(OOB(x,y)) return true;
            else if(boards[2][x][y] != stone_num) return true;
            else for (int i = 0; i < 19; i++) boards[2][i][y] = -1;
            return false;
        }

        if(OOB(x,y)) return false;
        else if(boards[2][x][y] == stone_num) return vertical(x+1,y, depth+1, stone_num);
        else return false;
    }

    // ---------------------------------------------------------------------------------

    public static boolean diagonal_row(int x, int y, int depth, int stone_num){
        if(depth == 5){
            if(OOB(x,y)) return true;
            else if(boards[3][x][y] != stone_num) return true;
            else {
                for (int i = 0; i < 6; i++) boards[3][x-i][y-i] = -1;
                return false;
            }
        }

        if(OOB(x,y)) return false;
        else if(boards[3][x][y] == stone_num) return diagonal_row(x+1,y+1, depth+1, stone_num);
        else return false;
    }

    // ---------------------------------------------------------------------------------

    public static boolean diagonal_high(int x, int y, int depth, int stone_num){
        if(depth == 0 && !OOB(x+1, y-1) && boards[4][x+1][y-1] == stone_num) return false;
        if(depth == 5){
            if(OOB(x,y)) return true;
            else if(boards[4][x][y] != stone_num) return true;
            else {
                for (int i = 0; i < 6; i++) boards[4][x+i][y-i] = -1;
                return false;
            }
        }

        if(OOB(x,y)) return false;
        else if(boards[4][x][y] == stone_num) return diagonal_high(x-1,y+1, depth+1, stone_num);
        else return false;
    }

    public static boolean OOB (int x, int y){
        return (x < 0 || y < 0 || x > 18 || y > 18);
    }
    /*
     * 범위 벗어나느지 확인
     * 기저 조건
     *    1. depth = 5번째 바둑알이 존재하고 그 바둑알 번호가 현재랑 같다. false 반환
     *        1에서 사용된 바둑 모두 -1로 바꾸어 사용 표시 남기기
     *    2. depth = 5번째 바둑알이 존재하지 않는다. true 반환
     * 계산
     *    1. 한칸씩 전진헤기먀 비득일 같은지 확인
     * */


}
