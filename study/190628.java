import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        double n = 0;


        String num = br.readLine();
        String[] txt_to_num = num.split(" ");
        int num1 = Integer.parseInt(txt_to_num[0]);
        int num2 = Integer.parseInt(txt_to_num[1]);
        n = (double)num1/(double)num2;



        bw.write(String.format("%.9f", n));

        bw.flush();
        bw.close();
    }

}

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double num1 = 0, num2 = 0;
        String input = br.readLine();
        for(int i=0;i<2;i++){

            String[] num_split = input.split(" ");
            num1 = Double.parseDouble(num_split[0]);
            num2 = Double.parseDouble(num_split[1]);
        }

        System.out.printf("%.9f", num1/num2);

    }
}

---------------------------------------------------------------------------------------------------
