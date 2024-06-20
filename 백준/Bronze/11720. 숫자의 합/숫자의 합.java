import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [10];

        String temp = br.readLine();

        for(int i = 0; i < temp.length(); i++){
            int now = Character.getNumericValue(temp.charAt(i));
            arr[now]++;
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // (i -> 숫자) * (arr[i] -> 숫자가 나온 횟수)
            sum += (i * arr[i]);
        }

        System.out.println(sum);

    }
}