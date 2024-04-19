import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 1874번 스택 수열
* */


public class Main {

    static int [] ans;

    public static void main(String[] args) throws IOException {

        // 1. 값 입력 ---------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ans = new int [N];

        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(br.readLine());
        }

        // [stack]을 배열로 구현
        int [] stack = new int [N];

        // top은 Stack의 지시자,  stack 배열에 값이 찰수록 올림. -> 뺄 때마다 내림
        int top = -1;
        StringBuilder sb = new StringBuilder();
        int index = 0;

        // stack 에 값 넣으면서 바로바로
        for (int i = 1; i <= N; i++) {

            // 1) 같은 경우가 아니라면 stack에 오름차순으로 값을 push 한다.
            stack[++top] = i;
            sb.append("+\n");

            // 2)  stack에 값이 존재하고, stack의 탑이랑 뽑아야할 값이랑 같으면 POP한다.
            while (top != -1 && stack[top] == ans[index]){

                top--;                      // 지시자 한 단계 내리기 pop을 구현한 것
                index++;                    // 지금 답은 이제 해결 했음으로 다음으로 넘어간다.
                sb.append("-\n");           // 값 넣기
            }
        }

        // 3) Stack이 empty가 아니고, stack의 peek이 답의 값과 같으면 pop
        while (top != -1 && stack[top] == ans[index]){
            top --;
            index ++;
            sb.append("-\n");
        }

        // 4) 3번에서 [stack]의 peek 과 현재 출력해야 하는 답 부분이 어긋나면 해당 문제는 풀 수 없는 문제 이므로
        //    stack 배열을 맨 아래까지 보지 않은 채, while loop를 나간다.
        //    따라서 top이 맨 밑바닥인 -1까지 오지 않으면 NO를 출력한다.
        System.out.println(top == -1? sb : "NO");
    }
}