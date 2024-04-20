import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 8958번 OX퀴즈 
* */


public class Main {

    static int [] ans;

    public static void main(String[] args) throws IOException {

        // 1. 값 입력 ---------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String [] OMR = br.readLine().split("");

            int stack = 1;
            int acc = 0;

            for (int i = 0; i < OMR.length; i++) {

                if(OMR[i].equals("O")){
                    acc +=stack++;
                }
                else{
                    stack = 1;
                }
            }
            System.out.println(acc);
        }
    }
}