import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1181
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        String[] word = new String[count];

        for(int i=0;i<count;i++)
            word[i] = br.readLine().trim();

        Arrays.sort(word);

        for(int i=0;i<count-1;i++){
            String temp;
            for(int j=i+1;j<count;j++){
                if(word[i].equals(word[j])){
                    for(int k=j;k<count-1;k++){
                        word[k] = word[k+1];
                    }
                    count--;
                }

                if(word[i].length() > word[j].length()){
                    temp = word[i];
                    word[i] = word[j];
                    word[j] = temp;
                }
            }
        }

        for(int i=0;i<count;i++)
            bw.write(word[i] + "\n");

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1181
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());

        HashSet<String> hs = new HashSet<>(); // 중복된거는 저장안함

        for(int i=0;i<count;i++)
            hs.add(br.readLine().trim());

        int size = hs.size(); // 처음에 횟수가 아닌 중복된것을 제외한 단어의 갯수

        String word[] = new String[size];
        hs.toArray(word);

        Arrays.sort(word, new Comparator<String>() { // ?????
            @Override
            public int compare(String wd1, String wd2) {
                return Integer.compare(wd1.length(), wd2.length());
            }
        });

        int i, j;
        for(i=0;i<size;i++){
            int len = word[i].length();

            for(j=i+1;j<size;j++){
                int tmp = word[j].length();
                if(len != tmp)
                    break;
            }
            Arrays.sort(word, i, j);
            i = j-1;
        }

        for(int k=0;k<size;k++)
            bw.write(word[k] + "\n");

        bw.flush();
        bw.close();
    }
}