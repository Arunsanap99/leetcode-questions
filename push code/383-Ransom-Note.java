class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Count characters available in magazine
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        // Use characters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';

            freq[index]--;

            if (freq[index] < 0) {
                return false;
            }
        }

        return true;
    }
}