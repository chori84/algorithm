import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "xproxmerqgram";
        Pattern p = Pattern.compile("[r]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println("GOOD");
        } else {
            System.out.println("NO!!");
        }
    }

}
