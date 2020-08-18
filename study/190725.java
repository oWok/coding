import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        String croatia_all = br.readLine().trim();
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i=0;i<croatia.length;i++){
            if(croatia_all.contains(croatia[i])) // contains -> 패턴여부 확인
                croatia_all = croatia_all.replaceAll(croatia[i], "*"); // replaceAll -> 변환
        }


        count = croatia_all.length();
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

