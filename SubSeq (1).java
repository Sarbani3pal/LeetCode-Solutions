import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SubSeq {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean flag = false;
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> asub = new ArrayList<Integer>();

        // int [] a = new int[n1];
        // int [] asub = new int[n2];

        for (int i = 0; i < n1; i++) {
           a.add(sc.nextInt());
        }
        for (int i = 0; i < n2; i++) {
            asub.add(sc.nextInt());
        }

        Collections.sort(a);
        Collections.sort(asub);

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n1; j++) {
                if(a.get(j)==asub.get(i)) 
                {
                    flag = true;
                    a.remove(j);
                    n1--;
                    break;
                }
                else flag = false;
            }
        }


        if(flag == true) System.out.println("true");
        else System.out.println("false");
    }
}
