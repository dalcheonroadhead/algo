import java.util.Scanner;

public class Main {

    static int ansR, ansC;
    static int [][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        // 1) 가로, 세로, 오른쪽 대각선 아래, 왼쪽 대각선 아래 확인하는 함수 (알 번호 받아서 straight 확인, 5개 되면, 중간 점을 static에 넣고 true, 아니면 false 출력)
        // 2) 1번 함수는 6개 되는 것도 체크 해야함.

        int ans = 0;
        for(int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                if(arr[i][j] != 0) {
                    if(straight(arr[i][j], i, j)) {
                        ans = arr[i][j];
                        break;
                    }
                }
            }
        }

        if(ans == 0) System.out.println(ans);
        else {
            System.out.println(ans);
            System.out.println(ansR + " " + ansC);
        }

    }


    public static boolean straight(int color, int r, int c) {
        int tempR = r;
        int tempC = c;
        int cnt = 0;

        // 가로
        while(!OOB(tempR,tempC) && arr[tempR][tempC] == color){
            cnt++;
            tempC++;
        }
        if(cnt == 5){
            ansR = tempR+1;
            ansC = tempC-2;
            return true;
        }

        // 세로
        tempR = r; tempC = c; cnt = 0;

        while(!OOB(tempR,tempC) && arr[tempR][tempC] == color){
            cnt++;
            tempR++;
        }
        if(cnt == 5){
            ansR = tempR-2;
            ansC = tempC+1;
            return true;
        }


        // 오대아
        tempR = r; tempC = c; cnt = 0;

        while(!OOB(tempR,tempC) && arr[tempR][tempC] == color){
            cnt++;
            tempR++;
            tempC++;
        }
        if(cnt == 5){
            ansR = tempR-2;
            ansC = tempC-2;
            return true;
        }


        // 왼대아
        tempR = r; tempC = c; cnt = 0;

        while(!OOB(tempR,tempC) && arr[tempR][tempC] == color){
            cnt++;
            tempR++;
            tempC--;
        }
        if(cnt == 5){
            ansR = tempR-2;
            ansC = tempC+4;
            return true;
        }

        return false;
    }

    public static boolean OOB (int r, int c) {
        return r < 0 || c < 0 || r >= 19 || c >= 19;
    }
}