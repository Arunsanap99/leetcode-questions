class Solution {

    private final String[] below20 = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder ans = new StringBuilder();

        if (num >= 1_000_000_000) {
            ans.append(convert(num / 1_000_000_000));
            ans.append(" Billion ");
            num %= 1_000_000_000;
        }

        if (num >= 1_000_000) {
            ans.append(convert(num / 1_000_000));
            ans.append(" Million ");
            num %= 1_000_000;
        }

        if (num >= 1000) {
            ans.append(convert(num / 1000));
            ans.append(" Thousand ");
            num %= 1000;
        }

        if (num > 0) {
            ans.append(convert(num));
        }

        return ans.toString().trim().replaceAll("\\s+", " ");
    }

    private String convert(int num) {

        StringBuilder ans = new StringBuilder();

        if (num >= 100) {
            ans.append(below20[num / 100]);
            ans.append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            ans.append(tens[num / 10]);
            ans.append(" ");
            num %= 10;
        }

        if (num > 0) {
            ans.append(below20[num]);
        }

        return ans.toString().trim();
    }
}