import java.io.*;

public class Main {
    static int[] num;
        public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/contest/problem/1912
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        String[] str = br.readLine().split(" ");
        int[] arr_num = new int[input_count];
        int[] dp = new int[input_count];

        for(int i=0;i<input_count;i++)
            arr_num[i] = Integer.parseInt(str[i]);

        dp[0] = arr_num[0];
        int max = arr_num[0];
        for(int i=1;i<input_count;i++){
            dp[i] = Math.max(dp[i-1] + arr_num[i], arr_num[i]);

            max = Math.max(max, dp[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();


    }


}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/contest/problem/2309
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dwarf = new int[9];
        int sum = 0;

        for(int i=0;i<9;i++) {
            dwarf[i] = Integer.parseInt(br.readLine().trim());
            sum += dwarf[i];
        }

        boolean check = false;

        for(int i=0;i<9;i++){
            if(check)
                break;

            for(int j=0;j<9;j++){
                if(i==j)
                    continue;

                if(sum-dwarf[i]-dwarf[j] == 100){
                    dwarf[i] = 0;
                    dwarf[j] = 0;
                    check = true;
                    break;
                }
            }
        }

        Arrays.sort(dwarf);

        for(int i=2;i<9;i++)
            bw.write(dwarf[i] + "\n");

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/7568
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean check = false;
        int input_num = Integer.parseInt(br.readLine().trim());
        int bunbahap = 0;


        for(int i=1;i<input_num;i++){
            bunbahap = 0;
            int number = i;
            int jare = (int)Math.pow(10,Math.floor((Math.log10(i))));
            for(int j=10;j<=jare;j*=10){
                bunbahap += number % 10;
                number/=10;
            }

            bunbahap += number;

            if(bunbahap + i == input_num){
                bw.write(i + "\n");
                check = true;
                break;
            }
        }


        if(!check)
            bw.write("0" + "\n");


        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------


