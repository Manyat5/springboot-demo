import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wwy
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
