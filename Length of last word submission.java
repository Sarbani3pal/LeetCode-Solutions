//Length of last word submission

public static int lengthOfLastWord(String s) {
        
        s = s.trim();

        int lastSpaceIndex = s.lastIndexOf(" ") + 1;

        String result = s.substring(lastSpaceIndex , s.length());
		
        return result.length();
    }