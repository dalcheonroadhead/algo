import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, sum = 0;
    static int [][] boards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int third = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        System.out.println(second + (second - third));
    }
}