import java.io.*;

public class Main {
    
    static int zero_count = 0;
    static int one_count = 0;
   // static long[] fibonaci = new long[41];

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1003

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine().trim());
        
        for(int i=0;i<count;i++){
            zero_count = 0;
            one_count = 0;
            int input_num = Integer.parseInt(br.readLine().trim());
            fibonaci_zero_one_input_num(input_num);
            bw.write(zero_count + " " + one_count + "\n");
        }

        bw.flush();
        bw.close();

    }
    
    public static int fibonaci_zero_one_input_num(int input_num){
        if(input_num == 0){
            zero_count++;
            return 0;
        }
        if(input_num == 1){
            one_count++;
            return 1;
        }

        return fibonaci_zero_one_input_num(input_num-1) + fibonaci_zero_one_input_num(input_num-2);
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1003

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine().trim());

        int[][] fibonaci = new int[41][2];

        fibonaci[0][0] = 1;
        fibonaci[1][1] = 1;

        for(int i=2;i<41;i++){
            for(int j=0;j<2;j++){
                fibonaci[i][j] = fibonaci[i-1][j] + fibonaci[i-2][j];
            }
        }

        for(int i=0;i<count;i++){
            int input_num = Integer.parseInt(br.readLine().trim());
            bw.write(fibonaci[input_num][0] + " " + fibonaci[input_num][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {

    static long[] til = new long[1000001];

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1904

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input_num = Integer.parseInt(br.readLine());

        bw.write((til_fu(input_num)%15746)+ "\n");
        bw.flush();
        bw.close();

    }

    static public long til_fu(int input_num){
        if(input_num == 0)
            return 0;
        if(input_num == 1)
            return 1;
        if(input_num == 2)
            return 2;
		
        return til[input_num] = til_fu(input_num-1) + til_fu(input_num-2);
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1904

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input_num = Integer.parseInt(br.readLine());

        long[] arr = new long[1000001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;


        for(int i=3;i<input_num+1;i++){
            arr[i] = arr[i-2] + arr[i-1];
            arr[i]%=15746;
        }
        

        bw.write(arr[input_num] + "\n");
        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/9461

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());

        long[] pabando = new long[1000001];

        pabando[0] = 0;
        pabando[1] = 1;
        pabando[2] = 1;


        for(int i=0;i<input_count;i++){
            int input_num = Integer.parseInt(br.readLine().trim());
            for(int j=3;j<input_num+1;j++){
                pabando[j] = pabando[j-2] + pabando[j-3];
            }

            bw.write(pabando[input_num] + "\n");
        }

        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {

    static long[] fabando = new long[100000];

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/9461

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<input_count;i++){
            int input_num = Integer.parseInt(br.readLine().trim());
            bw.write(fabando_fun(input_num) + "\n");
        }

        bw.flush();
        bw.close();

    }

    static public long fabando_fun(int input_count){
        if(input_count == 0)
            return 0;
        if(input_count == 1)
            return 1;
        if(input_count == 2)
            return 1;

        return fabando[input_count] = fabando_fun(input_count-2) + fabando_fun(input_count-3);
    }

}

---------------------------------------------------------------------------------------------------

