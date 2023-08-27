import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

       ArrayList<Integer> list =new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            list.add(Character.getNumericValue(N.charAt(i)));
        }

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        System.out.println(sb);
    }


}