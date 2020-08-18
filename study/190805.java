import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1929
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        boolean check = true;

        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        for(int i=min;i<=max;i++){
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i % j == 0) {
                    check = false;
                    break;
                }
            }

            if(check && i != 1){
                bw.write(i + "\n");
            }
            else
                check = true;

        }

        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/4948
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        while(true){
            boolean check = true;
            int sosu = Integer.parseInt(br.readLine().trim());
            int count = 0;
            if(sosu == 0)
                break;

            for(int i=sosu+1;i<=sosu*2;i++){
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i % j == 0){
                        check = false;
                        break;
                    }
                }

                if(check == true && i != 1)
                    count++;
                else
                    check = true;

            }

            bw.write(count + "\n");

        }


        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/4153
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x==0 && y==0 && z == 0)
                break;
            
            
            
            
            if(Math.pow(x,2) + Math.pow(y,2) == Math.pow(z,2) || Math.pow(x,2) + Math.pow(z,2) == Math.pow(y,2) || Math.pow(z,2) + Math.pow(y,2) == Math.pow(x,2))
                bw.write("right\n");
            else
                bw.write("wrong\n");
        }

        bw.flush();
        bw.close();
    }

}