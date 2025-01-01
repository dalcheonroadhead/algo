import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        int exponent = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            int now = 0;
            switch (c) {
                case 'A' : {
                    now = 10;
                    break;
                }
                case 'B' : {
                    now = 11;
                    break;
                }
                case 'C' : {
                    now = 12;
                    break;
                }
                case 'D' : {
                    now = 13;
                    break;
                }
                case 'E' : {
                    now = 14;
                    break;
                }
                case 'F' : {
                    now = 15;
                    break;
                }
                default: now = Character.getNumericValue(c);
            }
            answer += (int) (now * Math.pow(16,exponent++));
        }
        System.out.println(answer);
    }
}