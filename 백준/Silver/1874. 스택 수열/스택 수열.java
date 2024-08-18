import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb    = new StringBuilder();
        int N               = Integer.parseInt(br.readLine());
        int [] stack        = new int[N+1];
        int top             = 0;
        int value           = 1;

        for (int i = 1; i <= N ; i++) {
            int now = Integer.parseInt(br.readLine());
            while (value <= now) {
                if(value > N) break;
                stack[++top] = value++;
                sb.append("+\n");
            }
            if(stack[top] == now){
                top--;
                sb.append("-\n");
            }
            else if(stack[top] > now){
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}