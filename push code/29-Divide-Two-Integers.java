class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Check sign of answer
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ans = 0;

        // Try from largest bit
        for (int i = 31; i >= 0; i--) {

            if ((b << i) <= a) {
                a -= (b << i);
                ans += (1L << i);
            }
        }

        return negative ? (int) -ans : (int) ans;
    }
}