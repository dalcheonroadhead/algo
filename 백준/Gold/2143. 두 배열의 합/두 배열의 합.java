import java.io.*;
import java.util.*;

public class Main {

    /* b2143 두 배열의 합
    1. 각 배열의 구간합 구하기
    2. A 구간합을 기준으로 B 구간합을 더한다.
    3. B 구간합을 더했을 때, 총 계산 결과가 T를 넘어서면, A 구간합의 위치를 옮긴다.
    */

    public static void main(String[] args) throws IOException {
        // 0. 변수 모음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        int [] A;
        int [] B;
        int [] sumA;
        int [] sumB;
        ArrayList<Integer> secA = new ArrayList<>();
        ArrayList<Integer> secB = new ArrayList<>();
        // 1. 초기화
        T = Integer.parseInt(br.readLine());
        A = new int [Integer.parseInt(br.readLine())+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        B = new int [Integer.parseInt(br.readLine())+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        sumA = new int [A.length];
        sumB = new int [B.length];
        initSums(sumA, A);
        initSums(sumB, B);
        initSec(secA,sumA);
        initSec(secB,sumB);
        Collections.sort(secA);
        Collections.sort(secB);
//        System.out.println(Arrays.toString(sumA));
//        System.out.println(Arrays.toString(sumB));
        // 2. 계산
        System.out.println(calcul(secA,secB,T));
    }
    // 누적합 초기화 함수
    public static void initSums (int [] sum, int [] arr){
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
    }
    // 구간합 초기화 함수
    public static void initSec (ArrayList<Integer> sec, int [] sum){
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                sec.add(sum[i]-sum[j]);
            }
        }
    }
    // 본 계산 함수
    public static long calcul(ArrayList<Integer> secA, ArrayList<Integer> secB, int T){
        long ans = 0;
        int a = 0;
        int b = secB.size()-1;

        while ( a < secA.size() && b > -1){
            int now = secA.get(a) + secB.get(b);
            if(now == T){
                // 최초 secA.get(a) 값 혹은 secB.get(b) 값과 같은 값 세어서 중복값 빠르게 처리 위함
                long ac = 0; long bc = 0;
                long firstA = secA.get(a);
                while(a<secA.size() && firstA == secA.get(a)){
                    a++;
                    ac++;
                }

                long firstB = secB.get(b);
                while (b > -1 && firstB == secB.get(b)){
                    b--;
                    bc++;
                }
                ans += (ac * bc);
            }else if(now < T){
                a++;
            }else {
                b--;
            }
        }
        return ans;
    }
}