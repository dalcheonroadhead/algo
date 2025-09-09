import java.util.*;
import java.io.*;

// 백준 14891
// 백트래킹
public class Main {
    static boolean [] check;
    static int [][] wheels = new int [5][8];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            String row = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = row.charAt(j) - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            check = new boolean[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheel_num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            recur(wheel_num, dir);
        }
        int sum = 0;
        if(wheels[1][0] == 1) sum+=1;
        if(wheels[2][0] == 1) sum+=2;
        if(wheels[3][0] == 1) sum+=4;
        if(wheels[4][0] == 1) sum+=8;

        System.out.println(sum);
    }
    // 이웃이 돌아가야 하는지 체크
    // 돌려야할 경우, 이웃으로 넘어감
    // 자기만 돌림
    public static void recur (int wheel_num, int dir) {
        check[wheel_num] = true;
        switch (wheel_num) {
            case 1: {
                if(wheels[1][2] != wheels[2][6] && !check[2])  recur(2, (dir == 1)? -1 : 1);
                break;
            }
            case 2: {
                if(wheels[2][2] != wheels[3][6] && !check[3]) recur(3, (dir == 1)? -1 : 1);
                if(wheels[2][6] != wheels[1][2] && !check[1])  recur(1, (dir == 1)? -1 : 1);
                break;
            }
            case 3: {
                if(wheels[3][6] != wheels[2][2] && !check[2]) recur(2, (dir == 1)? -1 : 1);
                if(wheels[3][2] != wheels[4][6] && !check[4]) recur(4, (dir == 1)? -1 : 1);
                break;
            }
            case 4: {
                if(wheels[4][6] != wheels[3][2] && !check[3])  recur(3, (dir == 1)? -1 : 1);
                break;
            }
        }
        rotate(wheels[wheel_num], dir);
    }

    public static void rotate (int [] wheel, int dir) {
        if(dir == 1) {
            int temp = wheel[7];
            for (int i = 7; i >= 1; i--) {
                wheel[i] = wheel[i-1];
            }
            wheel[0] = temp;
        }else {
            int temp = wheel[0];
            for (int i = 0; i <= 6; i++) {
                wheel[i] = wheel[i+1];
            }
            wheel[7] = temp;
        }
    }
}