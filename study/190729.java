import java.io.*;


public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/15596
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int count = Integer.parseInt(br.readLine().trim());
        int[] input_num = new int[count];

        Test ts = new Test();

        for(int i=0;i<count;i++) {
            input_num[i] = Integer.parseInt(br.readLine().trim());
            ts.sum(input_num);
        }

        bw.write(ts.sum(input_num) + "");
        bw.flush();
        bw.close();


    }



}

class Test{
    long sum(int[] a){
        int sum = 0;

        for(int i=0;i<a.length;i++)
            sum+=a[i];


        return sum;
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/10872
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine().trim());

        math_factolary m_f = new math_factolary();

        bw.write(m_f.facto(num) + "");
        bw.flush();
        bw.close();
    }



}

class math_factolary{
    int facto(int num){
        int gub = 1;

        for(int i=1;i<=num;i++)
            gub*=i;

        return gub;
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args)  throws IOException {
        //https://www.acmicpc.net/problem/4673
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] selfNumber = new boolean[10001];

        for(int i=1;i<=10000;i++){
            int num = getSelfNumber(i);
            if(num <= 10000)
                selfNumber[num] = true;
        }

        for(int i=1;i<=10000;i++){
            if(!selfNumber[i]) {
                bw.write(i + "\n");
                bw.flush();
            }
        }


        bw.close();
    }

    public static int getSelfNumber(int num){
        int input_num = num;

        while (num>0){
            input_num += num%10;
            num /= 10;
        }

        return input_num;

    }
}
