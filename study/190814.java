import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11650
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        //String[][] coordinates = new String[count][2];
        int[][] coordinates = new int[count][2];

        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<2;j++)
                //coordinates[i][j] = st.nextToken();
                coordinates[i][j] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                
                return Integer.compare(o1[0], o2[0]);
            }
        });

//        Arrays.sort(coordinates, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
//            }
//        });



        for(int i=0;i<count;i++)
            bw.write(coordinates[i][0] + " " + coordinates[i][1] + "\n");

        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11651
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        //String[][] coordinates = new String[count][2];
        int[][] coordinates = new int[count][2];

        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<2;j++)
                //coordinates[i][j] = st.nextToken();
                coordinates[i][j] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return Integer.compare(o1[0], o2[0]);

                return Integer.compare(o1[1], o2[1]);
            }
        });

//        Arrays.sort(coordinates, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
//            }
//        });



        for(int i=0;i<count;i++)
            bw.write(coordinates[i][0] + " " + coordinates[i][1] + "\n");

        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------