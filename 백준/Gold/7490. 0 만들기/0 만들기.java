import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 7490번 0 만들기
* */


public class Main {

    static int N;
    static List<String> ans;

    static String [] op = {"+","-"," "};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test Case
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            // 1 ~ N 까지만 고려
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();

            // dfs 돌리기 -> ans에 문자열 형태로 찬다.
            dfs(1,"1");

            Collections.sort(ans);
            for (String s : ans) {
                System.out.println(s);
            }
            System.out.println();
        }


    }

    // depth와 같은 수가 맨 마지막에 적힌다.
    private static void dfs(int depth, String s){

        // 1. 기저 조건
        if(depth == N){
            // 2. 공백은 모두 땡겨서 붙이기 ex) 1+2 3 = 1+23
            String express = s.replaceAll(" ", "");

            if(cal(express)){
                ans.add(s);
            }

            return;
        }

        // 2. 계산 부분
        for(int i = 0; i < 3; i ++){
            dfs(depth+1, s+op[i]+(depth + 1));
        }

    }


    // 1. 0이 되면 True, 1이 되면 false
    private static boolean cal(String express){
        // 원본, 구분 문자, 구분 문자도 반환할지 boolean
        // 구분 문자를 여러 개하고 싶으면, 사이에 |을 놓으면 된다.
        // 공백은 위에서 모두 붙였음으로 여기선 같은 문자로 취급 받는다.
        StringTokenizer st = new StringTokenizer(express, "-|+", true);

        // 맨 처음 값 넣기
        int sum = Integer.parseInt(st.nextToken());

        // 토큰에 따라 계산 달리 하기
        while(st.hasMoreElements()){
            String s = st.nextToken();
            if(s.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        return sum == 0;
    }
}