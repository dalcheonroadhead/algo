import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 2.
        for (int i = 1; i < N; i++) {
           int pos =  binarySearch(list, i);
           int value = list.remove(i);
           list.add(++pos, value);
        }

        int [] sum = new int [N];
        sum[0] = list.get(0);
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + list.get(i);
        }
        int acc = 0;
        for (int i = 0; i < N; i++) {
            acc += sum[i];
        }

        System.out.println(acc);

    }

    public static int binarySearch(ArrayList<Integer> list, int now_idx) {
        int start = 0;
        int end = now_idx-1;

        while (start <= end){
            int mid = (start+end)/2;

            if(list.get(mid)< list.get(now_idx)){
                start = mid+1;
            }
            else if(list.get(mid) > list.get(now_idx)){
                end = mid-1;
            }
            else if(list.get(mid).equals(list.get(now_idx))){
                return mid;
            }
        }
        return end;
    }
}