class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int i =0;
        while(i<chars.length){
            char curr = chars[i];
            int count = 0;

            while(i < chars.length && chars[i] == curr){
                i++;
                count++;
            }

            //write char
            chars[idx++] = curr;

            if(count > 1 ){
                String num = String.valueOf(count);
                for(int j = 0; j<num.length(); j++){
                    chars[idx++] = num.charAt(j);
                }
            }

        }
        return idx ;
        
    }
}