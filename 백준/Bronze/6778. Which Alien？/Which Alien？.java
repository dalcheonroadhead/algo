import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int antennas    = Integer.parseInt(br.readLine());
        int eyes        = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if(antennas >= 3 && eyes <= 4) sb.append("TroyMartian").append("\n");
        if(antennas <= 6 && eyes >= 2) sb.append("VladSaturnian").append("\n");
        if (antennas<= 2 && eyes <= 3) sb.append("GraemeMercurian").append("\n");
        System.out.println(sb.toString());
    }
}