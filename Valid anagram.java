class Solution {
public boolean isAnagram(String s, String t) {

    // declare flag varaible
    Boolean flag = false;
    
    // sort both strings
    String s1 = sortString(s);
    String s2 = sortString(t);
    
    // check if sorted strings are the same
    if(s1.equals(s2))
        flag = true;
    
    return flag;
}

// function to sort input string in alphabetic order
private String sortString(String str)
{
    char[] ch = str.toCharArray();
    Arrays.sort(ch);
    return new String(ch);
}
}