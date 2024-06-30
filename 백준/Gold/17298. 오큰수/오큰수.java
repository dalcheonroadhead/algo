import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Node [] stack = new Node [N];
        int [] NGE = new int [N];
        int top = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        stack[++top] = new Node(0, Integer.parseInt(st.nextToken()));

        for (int i = 1; i < N; i++) {
            Node now = new Node(i, Integer.parseInt(st.nextToken()));

            while (top != -1 && stack[top].v < now.v){
                NGE[stack[top].i] = now.v;
                stack[top--] = null;
            }

            if(top == -1 || stack[top].v >= now.v){
                stack[++top] = now;
            }
        }

        for (int value : NGE){
            sb.append(value == 0? -1 : value).append(" ");
        }

        System.out.println(sb);

    }
}

class Node {
    int i;
    int v;

    public Node (int i, int v){
        this.i = i;
        this.v = v;
    }
}