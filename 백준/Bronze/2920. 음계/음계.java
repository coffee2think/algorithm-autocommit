import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] note = new int[8];
        for (int i = 0; i < note.length; i++) {
            note[i] = Integer.parseInt(st.nextToken());
        }

        int direction = Integer.compare(note[0], note[1]);

        for (int i = 1; i < note.length; i++) {
            if (Integer.compare(note[i - 1], note[i]) == direction) {
                continue;
            }

            direction = 0;
            break;
        }

        String result = direction < 0 ? "ascending" : direction > 0 ? "descending" : "mixed";
        System.out.println(result);
        br.close();
    }
}
