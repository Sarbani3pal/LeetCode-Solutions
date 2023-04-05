class Solution {
   public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = (ax2-ax1)*(ay2-ay1)+ (bx2-bx1)*(by2-by1);
        boolean xo = (bx1 >= ax1 && bx1 < ax2) || (ax1 >= bx1 && ax1 <= bx2);
        boolean yo = (by1 >= ay1 && by1 < ay2) || (ay1 >= by1 && ay1 <= by2);
        int[] xs = IntStream.of(ax1, ax2, bx1, bx2).sorted().toArray();
        int[] ys = IntStream.of(ay1, ay2, by1, by2).sorted().toArray();
        if (xo && yo) return total -(xs[2] - xs[1]) * (ys[2] - ys[1]);
        return total;
    }
}