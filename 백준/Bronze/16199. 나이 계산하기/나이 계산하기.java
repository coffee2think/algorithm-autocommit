import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        StringTokenizer st = new StringTokenizer(br.readLine());
        LocalDate birthday = LocalDate.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        LocalDate today = LocalDate.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // when
        int man = (int) ChronoUnit.YEARS.between(birthday, today);
        int se = today.getYear() - birthday.getYear() + 1;
        int yeon = se - 1;

        // then
        System.out.println(man);
        System.out.println(se);
        System.out.println(yeon);
        br.close();
    }
}
