import java.io.*;
import java.util.Arrays;

public class Main {
    /*
    * b 17425 약수의 합
    * 1. 소수 와 비소수 구별
    * 2. 소수 일 경우, 소수에서 특정 수 곱해서 그 배수 찾고,
    * */
    static int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        int [] fn = new int [MAX];
        Arrays.fill(fn, 1);
        long [] gn = new long [MAX];
        getFn(fn);
        getGn(fn,gn);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans_list = new StringBuilder();
        for (int t = 0; t < T; t++) {
            ans_list.append(gn[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(ans_list);
    }

    public static void getFn(int [] fn){
        for (int i = 2; i < MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                fn[i*j] += i;
            }
        }
    }
    public static void getGn(int [] fn, long [] gn){
        for (int i = 1; i < gn.length; i++) {
            gn[i] = gn[i-1] + fn[i];
        }
    }
}