import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

/*
 * 2108번 통계학
 * */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int acc = 0;
        for (int i = 0; i < N; i++) {
            acc +=arr[i];

            if(map.get(arr[i]) == null){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        // 평균
        sb.append(Math.round((float) acc /N)).append("\n");
        // 중앙값
        sb.append(arr[N/2]).append("\n");

        // 최빈값
        int mostButSecond = 0;
        int mostCnt = 0;
        boolean changeOnce = false;
        for (int temp : map.keySet()){
            if(mostCnt < map.get(temp)){

                // 모든 값 갱신
                mostButSecond = temp;
                mostCnt = map.get(temp);
                changeOnce = false;
            }

            else if(mostCnt == map.get(temp) && !changeOnce && mostButSecond < temp){
                mostButSecond = temp;
                changeOnce = true;
            }
        }

        sb.append(mostButSecond).append("\n");



        sb.append(arr[arr.length-1] - arr[0]);

        System.out.println(sb);




    }
}