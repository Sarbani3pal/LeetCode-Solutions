import java.util.*;
public class Sum {

    public static int[] twoSum(Set<Integer> s,int tsum)
    {
        for (int n : s) {
            int c = tsum - n;

            if(s.contains(c)) return new int[]{c,n};
        
            else
            {
                s.add(n);
            }
          
    }
    return new int[0];
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[]=new int[5];
        Set<Integer> s = new HashSet<Integer>();  //refernce variable of an interface used to refer to child class
                                                        // Dyanamic Binding
        int tsum = sc.nextInt();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        result = twoSum(s,tsum);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        
    }
}
