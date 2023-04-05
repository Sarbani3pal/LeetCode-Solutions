import java.util.*;

public class Cognizant_LongestPeak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 0, p = 0;
        int ans = 0;
        int ar[] = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = sc.nextInt();
        }

        for (int i = 1; i <= n - 2;) {
            int count = 1;
            if (ar[i] > ar[i - 1] && ar[i] > ar[i + 1])
            // no neighbourhood is larger
            {
                int j = i;
                while (j > 0 && ar[j] > ar[j - 1]) {
                    j--;
                    m = j;
                    count++;
                }
                while (i < n - 1 && ar[i] > ar[i + 1]) {
                    i++;
                    p = i;
                    count++;
                }
                ans = Math.max(count, ans);

            } else {
                i++;
            }
        }
        System.out.println(ans);
        for (int i = m; i <= p; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}