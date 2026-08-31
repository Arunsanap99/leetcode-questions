class Solution {
    public String reverseWords(String s) {
        String words [] = s.split(" ");
        StringBuilder ans = new StringBuilder();

        // run loop for each word
         for(int i = 0; i<words.length; i++){
            StringBuilder word = new StringBuilder(words[i]);
             word.reverse();
             ans.append(word);

             if(i != words.length-1){
                ans.append(" ");
             }
         }
        return ans.toString();
    }
}