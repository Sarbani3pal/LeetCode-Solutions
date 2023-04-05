class DisjointSet {
    
	// Parent Array to hold smallest character linked with current character
    int[] par = new int[26];
    
    DisjointSet() {
        for(int i = 0; i < 26; i++) par[i] = i;
    }
    
	// Compressend Find parent Function
    int findPar(int x) {
        
		// If x is parent of himself, return
        if(par[x] == x) return x;
        
		// Else find its parent update its parent array and return
        return par[x] = findPar(par[x]);
        
    }
    
	// Union just updates the parent
    void union(int x, int y) {
        
        x = findPar(x);
        y = findPar(y);
        
		// Lexicographically smaller character will become the parent
        if(x < y) par[y] = par[x];
        else par[x] = par[y];
    
    }
    
}

class Solution {    
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        DisjointSet ds = new DisjointSet();
        
        for(int i = 0; i < s1.length(); i++) {
            
            int x = (int)(s1.charAt(i) - 'a');
            int y = (int)(s2.charAt(i) - 'a');
            
			// Making a union of all given equivalent charactrers
            ds.union(x, y);
            
        }
        
		// Adding parent of each character from the Base String
		// Parent = smallest equivalent character linked with it !!!
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < baseStr.length(); i++) {
            char c = (char)('a' + ds.findPar((int)(baseStr.charAt(i) - 'a')));
            ans.append(c);
        }
        
        return ans.toString();
    }

}