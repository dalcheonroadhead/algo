import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    /*
    * 1377 버블 소트
    * (1) 모든 원소의 원래 index를 저장
    * (2) 모든 원소의 정렬 후 index를 구한다.
    * (3) (1) - (2) 중 최대값을 구한다.
    * (4) 최대값 + 1을 출력한다.
    * */
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num [] nums = new Num[N];
        for (int i = 0; i < N; i++) {
            nums[i] = new Num(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o.v));
        for (int i = 0; i < N; i++) {
            if(i < nums[i].i) answer = Math.max(answer, nums[i].i - i);
        }
        System.out.println(answer+1);
    }
}

class Num {
    int i;
    int v;

    public Num(int i, int v){
        this.i = i;
        this.v = v;
    }
}