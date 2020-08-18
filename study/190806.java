import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1085
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int w_x = w - x < x ? w - x : x;
        int h_y = h - y < y ? h - y : y;

        int distance = w_x < h_y ? w_x : h_y;

        bw.write(distance + "\n");
        bw.flush();
        bw.close();


    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/3009
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] point_x = new int[3], point_y = new int[3];
        int x = 0, y = 0;

        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            point_x[i] = Integer.parseInt(st.nextToken());
            point_y[i] = Integer.parseInt(st.nextToken());
        }

        boolean x_check = true;
        boolean y_check = true;

       for(int i=0;i<2;i++){
           for(int j=i+1;j<3;j++){
               if(point_x[i] == point_x[j]){
                   x_check = false;
                   break;
               }
               if(point_y[i] == point_y[j]){
                   y_check = false;
                   break;
               }
           }

           if(x_check)
               x = point_x[i];
           else
               x_check = true;

           if(y_check)
               y = point_y[i];
           else
               y_check = true;
       }

        bw.write(String.format("%d %d",x,y));
        bw.flush();
        bw.close();

    }

}

