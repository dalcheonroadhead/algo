import java.io.*;
import java.util.*;

public class Main{
    static int TC, N, M, W;
    static Edge [] edges;
    static int [] dist;
    static class Edge {
        int s;
        int e;
        int w;

        public Edge (int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0)
                break;
            else {
                System.out.println(a+b);
            }
        }
    }

}