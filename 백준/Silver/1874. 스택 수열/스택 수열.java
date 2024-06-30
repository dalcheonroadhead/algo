import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] stack = new int [N];
        int [] ans = new int [N];
        int stackIter = 0;
        int ansIter = 0;

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            // 답 배열의 현재 바라보고 있는 원소보다 i값이 작거나 같다면 stack에 삽입
            // stack에 값이 답 배열의 현 원소와 같다면 꺼내기
            // 답 배열의 현 원소보다 스택에 값이 크다면 그것은 만들 수 없는 수열이므로 NO 출력 후 종료

            if(i == 0 || stackIter <= 0){
                stack[stackIter++] = i+1;
                sb.append("+").append("\n");
            } else if(ans[ansIter] >= stack[stackIter-1]){
                stack[stackIter++] = i+1;
                sb.append("+").append("\n");
            }

            while(ans[ansIter] == stack[stackIter-1]){
                sb.append("-").append("\n");
                ansIter++;

                stack[stackIter-1] = -1;
                stackIter--;

                if(ansIter == N || stackIter == 0) break;

            }

            if(stackIter !=0 && ans[ansIter] < stack[stackIter-1]) {
                System.out.println("NO");
                return;
            }

        }

        System.out.println(sb);

    }
}