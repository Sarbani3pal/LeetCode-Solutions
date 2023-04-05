//Add binary

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();

		Stack<Character> listA = new Stack<>();
		Stack<Character> listB = new Stack<>();


		for (int i = 0, j = 0; i < lenA || j < lenB; i++, j++) {
			if (listA.size() < lenA) {
				listA.add(a.charAt(i));
			}
			if (listB.size() < lenB) {
				listB.add(b.charAt(j));
			}
		}
		
		int sizeA = listA.size(), sizeB = listB.size();

		boolean addOne = false;
		char getA = 0, getB = 0;
		String out = "";
		
		for(int i = sizeA, j = sizeB; i > 0 || j > 0; i--, j--) {
			if (sizeA > 0) {
				getA = listA.pop();
			} else {
				getA = '0';
			}
			sizeA--;
			if (sizeB > 0) {
				getB = listB.pop();
			} else {
				getB = '0';
			}
			sizeB--;

			if (getA == '1' && getB == '1') {
                if(out.length()==0){
                    out = "0" + out;
                    addOne = true;
                }else{
                    if(addOne){
                        out = "1" + out;
                        addOne = true;
                    }else{
                        out = "0" + out;
                        addOne = true;
                    }
                }
			} else if ((getA == '1' && getB == '0') || (getA == '0' && getB == '1')) {
				if (addOne) {
					out = "0" + out;
                    addOne = true;
				} else {
					out = "1" + out;
					addOne = false;
				}
			} else {
				if (addOne) {
					out = "1" + out;  
				} else {
					out = "0" + out;	   
                }
                addOne = false;
			}
		}
        if(addOne){
            out = "1" + out;
        }
		return out; 
    }
}