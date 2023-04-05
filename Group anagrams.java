class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//       Initialization of Hashmap Key is type of String and Value is type of List<String
        HashMap<String, List<String> > map = new HashMap<>(); 
        
        
        for(String s : strs){ // Taking one by one String from strs array
            char[] chars = s.toCharArray(); //Converting String to Char Array
            Arrays.sort(chars); // Sorting The Char Array by using inbuilt Sorting Method
            String key = String.valueOf(chars); //Converting Sorted Char array to String. It will act as a Key for our hashmap
            if(map.containsKey(key))
                map.get(key).add(s); //If key exist then add the String or append the string to the end of the list
            else{
                map.put(key, new ArrayList<>()); // If key not present then initialize the ArrayList 
                map.get(key).add(s); // and add the Perticular String to that key.
            } 
        }
        
        List<List<String>> answer = new ArrayList<>(); // Initialize the Answer arraylist of arraylist
        for(String key : map.keySet()) // keySet will give you all the keys available for that Hashmap use it to get the keys and get the list out of it
            answer.add(map.get(key));  // Append the list of given key to the answer list
        
        
        return answer; // return the answer array
    }
}