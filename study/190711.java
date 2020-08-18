import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<count;i++){
            String num_all = br.readLine();
            String[] num = num_all.split(" ");
            int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int check_count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<check_count;i++){
            String num_all = br.readLine();
            String[] num = num_all.split(" ");
            int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            int check = i+1;
            bw.write("Case #" + check + ": " + sum + "\n");
        }

        bw.flush();
        bw.close();


    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int check_count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<check_count;i++){
            String num_all = br.readLine();
            String[] num = num_all.split(" ");
            int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            int check = i+1;
            bw.write("Case #" + check + ": " + num[0] + " + " + num[1] + " = " + sum + "\n");
        }

        bw.flush();
        bw.close();


    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
       while(true){
            String num_all = br.readLine();
            String[] num = num_all.split(" ");
            int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            //int check = i+1;
            //bw.write("Case #" + check + ": " + num[0] + " + " + num[1] + " = " + sum + "\n");
           if(Integer.parseInt(num[0]) != 0 || Integer.parseInt(num[1]) != 0)
               bw.write(sum + "\n");
           else if(Integer.parseInt(num[0]) == 0 && Integer.parseInt(num[1]) == 0)
               break;

        }

        bw.flush();
        bw.close();


    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num_all = "";

        while((num_all = br.readLine()) != null && num_all.length() != 0){
           String[] num = num_all.split(" ");
           int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);

           bw.write(sum + "\n");

        }

        bw.flush();
        bw.close();


    }
}
