import java.util.*;
import java.io.*;

public class Main {
    static int [][] wheels = new int [4][8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            String row = br.readLine();
            for(int j = 0; j < 8; j++) {
                wheels[i][j] = row.charAt(j) - 48;
            }
        }
        int R = Integer.parseInt(br.readLine());
        for(int i = 0; i < R; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            calculate(num, dir);
        }

        int sum = 0;
        if(wheels[0][0] == 1) sum += 1;
        if(wheels[1][0] == 1) sum += 2;
        if(wheels[2][0] == 1) sum += 4;
        if(wheels[3][0] == 1) sum += 8;

        System.out.println(sum);
    }

    public static void calculate(int num, int dir) {
        int [] rotateDir = new int [4];
        checkNS(rotateDir, num, dir); // 극이 다른지 확인

        for(int i = 0; i < 4; i++){
            if(rotateDir[i] != 0) rotate(i, rotateDir[i]);
        }
    }

    public static void checkNS(int [] rotateDir, int num, int dir) {

        if(num < 0 || num >= 4) return;
        rotateDir[num] = dir;
        if(num - 1 >= 0 && wheels[num-1][2] != wheels[num][6] && rotateDir[num - 1] == 0) {
            checkNS(rotateDir, num - 1, dir == 1 ? -1 : 1);
        }
        if(num + 1 < 4 && wheels[num][2] != wheels[num+1][6] && rotateDir[num+1] == 0) {
            checkNS(rotateDir, num + 1, dir == 1? -1 : 1);
        }

    }

    public static void rotate(int num, int dir){
        if(dir == 1) {
            int temp = wheels[num][7];
            int iter = 6;
            while(iter >= 0){
                wheels[num][iter+1] = wheels[num][iter];
                iter--;
            }
            wheels[num][0] = temp;
        }

        if(dir == -1) {
            int temp = wheels[num][0];
            int iter = 1;
            while (iter < 8) {
                wheels[num][iter-1] = wheels[num][iter];
                iter++;
            }
            wheels[num][7] = temp;
        }
    }
}