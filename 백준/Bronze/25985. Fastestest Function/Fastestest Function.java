import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int before = Integer.parseInt(st.nextToken());
        int after = Integer.parseInt(st.nextToken());

        // when
        double index = (double) (before * (100 - after)) / (after * (100 - before));
        
        // then
        System.out.println(index);
        br.close();
    }
}
