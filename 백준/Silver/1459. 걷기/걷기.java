import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    /*
    * b 1459 걷기
    * 1) 대각선 이동을 목적지와 x축이 일치할 때까지 간다. (이때 비용은 2S와 W 중 하나 선택)
    * 2) x축과 일치한 후에는, 다시 S와 W 확인 하여 최소값으로 이동한다.
    * */
    static long cost = 0;
    static long startX = 0;
    static long startY = 0;
    static long X,Y,S,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        crossOver();
        goFront();
        System.out.println(cost);
    }

    public static void crossOver() {
        long go = Math.min(X,Y);
        startX = go; startY = go;
        cost += go*Math.min(2*S, W);
    }

    public static void goFront() {
        long cur;
        long dest;
        if(startX == X){
            cur = startY;
            dest = Y;
        }else {
            cur = startX;
            dest = X;
        }

        if(S > W) {
            if(Math.abs(cur-dest)%2 == 0){
                cost += Math.abs(cur-dest)*W;
            }
            else{
                cost += (Math.abs(cur-dest)-1)*W;
                cost += S;
            }
        }else {
            cost += Math.abs(cur-dest)*S;
        }
    }
}