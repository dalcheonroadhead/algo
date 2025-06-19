import java.util.*;
import java.io.*;

public class Main {
    static int [] alphabet;
    static StringBuilder ans = new StringBuilder ();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++){
            char [] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            ans.append(String.valueOf(arr)).append("\n");
            while(np(arr)){};
        }

        System.out.println(ans.toString());
    }

    public static boolean np (char [] prev) {
        // 1. 꼭대기 값 찾기
        int peak  = prev.length - 1;
        while (peak > 0 && prev[peak - 1] >= prev[peak]) peak--;
        if(peak == 0) return false;

        // 2. left보다 큰 최소값 right 찾아서 둘이 자리 바꾸기
        int left = peak - 1;
        int right = prev.length - 1;
        while(left < right && prev[left] >= prev[right]) right--;

        char temp = prev[right];
        prev[right] = prev[left];
        prev[left] = temp;

        // 3. 꼭대기의 오른편 오름차순 정렬
        left = peak;
        right = prev.length -1;
        while(left < right) {
            char temp2 = prev[right];
            prev[right] = prev[left];
            prev[left] = temp2;
            left++;
            right--;
        }

        ans.append(String.valueOf(prev)).append("\n");

        return true;
    }
}