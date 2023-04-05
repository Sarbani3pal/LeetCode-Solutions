import java.util.*;

class Pair {
    public int f, s;

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

public class Cognizant_Intervals {
    public static ArrayList<Pair> mR(ArrayList<Pair> al) {
        ArrayList<Pair> res = new ArrayList<Pair>();
        res.add(new Pair(al.get(0).f, al.get(0).s));

        int f1, f2, s1, s2;
        for (int i = 1; i < al.size(); i++) {
            f1 = al.get(i).f;
            s1 = al.get(i).s;
            f2 = res.get(res.size() - 1).f;
            s2 = res.get(res.size() - 1).s;

            if (f1 <= s2) {
                res.get(res.size() - 1).s = Math.max(s1, s2);
            } else {
                res.add(new Pair(f1, s1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Pair> al = new ArrayList<Pair>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            al.add(new Pair(x, y));
        }
        Collections.sort(al, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) { // compare abstract method overloaded
                return p1.f - p2.f;
            }
        });
        ArrayList<Pair> ans = mR(al);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(String.format("[%d,%d] ", ans.get(i).f, ans.get(i).s));
        }
    }
}
