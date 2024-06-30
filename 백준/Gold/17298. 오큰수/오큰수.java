import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] value = new int[N];      // index에 해당하는 value 저장
        int [] stack = new int[N];      // index 만 저장
        int [] nge = new int[N];        // index 당 자신의 오큰수 저장
        int top = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        stack[++top] = 0;

        for (int i = 1; i < N; i++) {
            // 현재 조회 중인 값보다 stack의 top 값이 작은 경우
            while(top != -1 && value[stack[top]] < value[i]){
                nge[stack[top--]] = value[i];
            }

            if(top == -1 || value[stack[top]] >= value[i]){
                stack[++top] = i;
            }
        }

        for (int now : nge){
            sb.append(now == 0? -1 : now).append(" ");
        }

        System.out.println(sb);
    }
}