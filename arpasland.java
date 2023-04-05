import java.util.Scanner;

public class arpasland {
    public static boolean checkNameValidity(String n) {
        // boolean flag = false;
        String regex1 = "^([0-9]{2}[A|E|I|O|U]{1}[0-9]{3}([-])[0-9]{2})$";
        if(n.matches(regex1)) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        System.out.println((checkNameValidity(n) ? "valid" : "invalid"));

    }
}
