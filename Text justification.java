//Text justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            StringBuilder line = new StringBuilder();
            int len = 0;
            int wlen =0;
            int start=i;
            int end = i;
            while(end<words.length && len + words[end].length() <= maxWidth) {
                len += words[end].length()+1;
                wlen += words[end].length();
                end++;
            }
            int gaps = end - start - 1;
            int padding = end == words.length ? gaps : maxWidth-wlen;

            int spacing = gaps == 0 ? 1 : padding / gaps;
            int extraSpace = gaps != 0 ? padding % gaps : 0;
            for(int j=start; j<end; j++) {
                line.append(words[j]);
                if(j!= end-1) {
                    line.append(" ".repeat(spacing));
                }
                if(extraSpace>0) {
                    line.append(" ");
                    extraSpace--;
                }
            }
            while(line.length() < maxWidth) {
                line.append(" ");
            }
            i = end-1;
            result.add(line.toString());
        }
        return result;
    }
}