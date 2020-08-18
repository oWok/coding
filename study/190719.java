import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number;
        int sum = 0, num = 0, check_count;

        check_count = Integer.parseInt(br.readLine().trim());
        number = br.readLine().trim();


        for(int i=0;i<check_count;i++){
            num = Integer.parseInt(number.charAt(i) + "");
            sum += num;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int check_count, word_count;
        String word;

        check_count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<check_count;i++){
            String wordcount_word = br.readLine();
            String[] num_word = wordcount_word.split(" ");

            word_count = Integer.parseInt(num_word[0]);
            word = num_word[1];
            for(int j=0;j<word.length();j++){
                for(int k=0;k<word_count;k++){
                    bw.write(word.charAt(j));
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

