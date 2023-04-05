//Simplify path

class Solution {
   public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s:paths){
            if(s.equals("")) continue;
            else if(s.equals(".")) continue;
            else if(s.equals("..")) 
                if(!st.isEmpty()) st.pop();
                else continue;
            else st.add(s);
        }
        return "/"+String.join("/", st);
    }
}