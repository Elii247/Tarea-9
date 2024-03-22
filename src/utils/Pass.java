package utils;
import java.util.regex.Pattern;

public class Pass {
    public static boolean password(String password) {

        return Pattern.matches("^[a-zA-Z0-9-@!&()=?$#._%+-]{8,15}$", password);
    }
}
