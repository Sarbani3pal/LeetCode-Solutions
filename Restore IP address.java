class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return ipList;
        }
        StringBuilder sb = new StringBuilder();
        restoreIp(s, 0, 0, sb, ipList);
        return ipList;
    }
    
    private void restoreIp(String s, int pos, int level, StringBuilder sb, List<String> ipList) {
        if (level == 3) {   // get rest of num
            String numStr = s.substring(pos);
            if (validate(numStr)) {
                ipList.add(sb.toString() + numStr); // we didn't append numStr to sb, no need to remove
            } 
            return;
        }
        for (int nextPos = pos + 1; nextPos < s.length() && nextPos <= pos + 3; ++nextPos) {
            String numStr = s.substring(pos, nextPos);
            if (!validate(numStr)) {
                continue;
            }
            sb.append(numStr).append('.');
            restoreIp(s, nextPos, level + 1, sb, ipList);
            sb.setLength(sb.length() - numStr.length() - 1); // removeNumStr and "." before backtracking
        }
    }
    
    private boolean validate(String s) {
        if (s.length() == 1) {
            return s.compareTo("0") >= 0 && s.compareTo("9") <= 0;    // separate, as"0" < "00" < "10"
        } else if (s.length() == 2) {
            return s.compareTo("10") >= 0 && s.compareTo("99") <= 0; 
        } else if (s.length() == 3) {
            return s.compareTo("100") >= 0 && s.compareTo("255") <= 0;
        }
        return false;
    }
}