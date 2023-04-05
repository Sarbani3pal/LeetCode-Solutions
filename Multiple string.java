//Multiple string

class Solution {
    public String multiply(String num1, String num2) {
        
        // if num1 or num2 starts with 0 means product will always be zero as per def
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        
        final int len1 = num1.length();
        final int len2 = num2.length();
        final int resLen = len1 + len2; // max length of res possible
        
        int res[] = new int[resLen];
        int s = 0;
        for (int i=len1-1; i>=0; i--) {
			// stores prod result of i char
            int mulRes[] = new int[resLen];
			// multiplication result index will keep shifting
            int mr = resLen-s-1, carry = 0;
            for (int j=len2-1; j>=0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int prod = (x * y) + carry;
                mulRes[mr--] = prod % 10;
                carry = prod / 10;
            }
            if (carry > 0) mulRes[mr] = carry;
            s++;
            res = add(res, mulRes);
        }
        
        final StringBuilder sb = new StringBuilder();
        
        int i=0;
        while (i < res.length && res[i] == 0) i++;
        
        while (i < res.length) {
            sb.append(res[i]);
            i++;
        }
        return sb.toString();
    }
    
    private int[] add(int[] num1, int[] num2) {
        int[] res = new int[num1.length];
        int r = num1.length -1, carry = 0;
        for (int i=num1.length-1; i>=0; i--) {
            final int sum = num1[i] + num2[i] + carry;
            res[i] = sum % 10;
            carry = sum / 10;
        }
        return res;
    }
}