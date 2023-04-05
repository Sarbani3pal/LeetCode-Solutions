class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        
        HashMap<Character,Integer> needs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> window = new HashMap<Character,Integer>();
        for (char c : t.toCharArray()) needs.put(c, needs.getOrDefault(c,0) + 1);
        
        int left = 0, right = 0;
        // counts elements in the window that meet the needs
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // update the window
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            // System.out.println(window);
            // determine if left window needs to shrink
            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // System.out.println("start"+start);
                char d = s.charAt(left);
                left++;
                // update the window
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE? "" : s.substring(start, start+len);
    }
}