import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int num1, num2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num1 = Integer.parseInt(br.readLine().trim());
        num2 = Integer.parseInt(br.readLine().trim());

        bw.write(num1*(num2%10) + "\n");
        bw.write(num1*(num2%100-num2%10)/10 + "\n");
        bw.write(num1*(num2/100) + "\n");
        bw.write(num1*num2 + "\n");

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int num1 = 0, num2 = 0, num3 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numb = br.readLine();

        for(int i=0;i<2;i++){
            String[] n = numb.split(" ");
            num1 = Integer.parseInt(n[0]);
            num2 = Integer.parseInt(n[1]);
            num3 = Integer.parseInt(n[2]);
        }

        bw.write((num1+num2)%num3 + "\n");
        bw.write((num1%num3 + num2%num3)%num3 + "\n");
        bw.write((num1*num2)%num3 + "\n");
        bw.write((num1%num3*num2%num3)%num3 + "\n");


        bw.flush();
        bw.close();

    }
}


---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int num1 = 0, num2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numb = br.readLine();

        for(int i=0;i<2;i++){
            String[] n = numb.split(" ");
            num1 = Integer.parseInt(n[0]);
            num2 = Integer.parseInt(n[1]);
        }

        bw.write(num1+num2 + "\n");
        bw.write(num1-num2 + "\n");
        bw.write(num1*num2 + "\n");
        bw.write(num1/num2 + "\n");
        bw.write(num1%num2 + "\n");

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------