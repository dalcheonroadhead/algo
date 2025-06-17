import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int [][] members;
    static boolean [] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t = 0; t < TC; t++){
            members = new int [11][11];
            for(int i = 0; i < 11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++){
                    members[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isVisited = new boolean [11];
            permutation(0, new int [11]);
            System.out.println(answer);
            answer=0;
        }
    }
    // members의 행 = 선수 번호, 열은 포지션
    // answer의 index = 선수 번호, answer의 value = 포지션
    // isVisited의 index = 포지션, value = 포지션 썼는지 아닌지
    public static void permutation(int depth, int [] position) {
        // base-case
        if(depth == 11) {
            int sum = 0;
            for(int i = 0; i < 11; i++){
                sum += members[i][position[i]];
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 11; i++) {
            if(isVisited[i]) continue;
            if(members[depth][i] == 0) continue;

            isVisited[i] = true;
            position[depth] = i;
            permutation(depth+1, position);
            isVisited[i] = false;
        }
    }
}