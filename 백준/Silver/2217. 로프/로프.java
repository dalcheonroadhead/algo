import java.util.*;
import java.io.*;

// 2217 로프
public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
         int [] rope = new int [N];
         int [] acc = new int [N];
         for(int i = 0 ; i < N; i++){
             rope[i] = Integer.parseInt(br.readLine());
         }
         Arrays.sort(rope);
         for(int i = 0; i < rope.length; i++){
             acc[i] = rope[i]*(rope.length - i);
         }
         Arrays.sort(acc);
         System.out.println(acc[acc.length-1]);
    }
}