import java.io.*;


public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/1065
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_hansu = Integer.parseInt(br.readLine().trim());

        bw.write(hansu_fun(input_hansu) + "\n");
        bw.flush();
        bw.close();

    }

    private static int hansu_fun(int input){
        int sum;

        if(input < 100)
            sum = input;
        else
            sum = 99;

        if(input > 100) {
            for (int i = 100; i <= input; i++) {
                int num1 = i % 10;
                int num2 = (i / 10) % 10;
                int num3 = i / 100;

                if(num2 * 2 == num1 + num3)
                    sum++;
            }
        }

        return sum;
    }
}

---------------------------------------------------------------------------------------------------

