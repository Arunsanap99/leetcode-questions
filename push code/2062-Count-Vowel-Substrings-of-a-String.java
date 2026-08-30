class Solution {

    public int countVowelSubstrings(String word) {

        int ans = 0;

        for (int i = 0; i < word.length(); i++) {

            int[] freq = new int[5];
            int unique = 0;

            for (int j = i; j < word.length(); j++) {

                char ch = word.charAt(j);

                // Stop if character is not a vowel
                if (ch == 'a') {
                    if (freq[0] == 0) unique++;
                    freq[0]++;
                }
                else if (ch == 'e') {
                    if (freq[1] == 0) unique++;
                    freq[1]++;
                }
                else if (ch == 'i') {
                    if (freq[2] == 0) unique++;
                    freq[2]++;
                }
                else if (ch == 'o') {
                    if (freq[3] == 0) unique++;
                    freq[3]++;
                }
                else if (ch == 'u') {
                    if (freq[4] == 0) unique++;
                    freq[4]++;
                }
                else {
                    break;
                }

                // All 5 vowels are present
                if (unique == 5) {
                    ans++;
                }
            }
        }

        return ans;
    }
}