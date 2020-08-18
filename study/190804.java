import java.io.*;


public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/11729
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_num = Integer.parseInt(br.readLine().trim());

//        if(input_num == 0)
//            bw.write("0" + "\n");
//        else
            bw.write(fact(input_num) + "\n");

        bw.flush();
        bw.close();
    }

    public static int fact(int input){
        if(input == 1)
            return 1;
        else if(input > 1)
            return input * fact(input - 1);
        else
            return 1;
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1978
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        int[] number = new int[count];
        int sosu = 0;
        boolean check = true;

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for(int i=0;i<count;i++) {
            number[i] = Integer.parseInt(st.nextToken());

            if(number[i] == 1)
                check = false;
            else{
                for(int j=2;j<=number[i]/2;j++){
                    if(number[i] % j == 0)
                        check = false;
                }
            }

            if(check)
                sosu++;


            check = true;


        }

        bw.write(sosu + "");
        bw.flush();
        bw.close();


    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2581
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_min, input_max, sum = 0;
        input_min = Integer.parseInt(br.readLine().trim());
        input_max = Integer.parseInt(br.readLine().trim());
        boolean check = true;

        int min = 10000;

        for(int i=input_min;i<=input_max;i++) {
            for (int j=2;j<=i/2;j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }

            if (check && i != 1) {
                min = (min < i) ? min : i;
                sum += i;
            }
            else
                check = true;
        }
        if(sum == 0)
            bw.write("-1" + "");
        else {
            bw.write(sum + "\n");
            bw.write(min + "");
        }
        bw.flush();
        bw.close();
    }

}