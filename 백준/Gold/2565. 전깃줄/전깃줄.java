import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws  IOException {

        // 입력 값 받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Bridge> list = new ArrayList<>();

        int [] dp = new int[N];
        Arrays.fill(dp, 1);


        for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        list.add(new Bridge(left,right));
        }

        // 입력값을 왼쪽 전봇대의 번호에 따라 정렬
        list.sort(Comparator.comparingInt(o -> o.left));

        int maxDP = 0;
        for (int i = 0; i < list.size(); i++) {

            Bridge now = list.get(i);
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(now.right > list.get(j).right){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            maxDP = Math.max(dp[i], maxDP);
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).left + " / " + list.get(i).right + " / " + dp[i]);
//        }

        System.out.println(N - maxDP);

    }
}

class Bridge {
    int left;
    int right;

    public Bridge (int left, int right){
        this.left = left;
        this.right = right;
    }
}