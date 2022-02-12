import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(out)
        // String input_id = br.readLine();

        int input_year = Integer.parseInt(br.readLine());
        int output_year = input_year - 543;

        System.out.println(output_year);

        // System.out.println(input_id + "??!");

        br.close();

    }
}
