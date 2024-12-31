import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = br.readLine();
            if (input.equals("#")) break;
            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);
                switch (now) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        cnt++;
                }
            }
            answer.append(cnt).append("\n");
        }
        System.out.println(answer);
    }
}