class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            return 1 / power(x,-N);
        }
        return  power(x, N);
        }

     public static double power(double x , long N){
            if(N == 0){
                return 1;
                }
        double half = power(x,  N/2);

          if(N%2 == 0){
            return half * half;
         }else{
            return x * half * half;
         }
        
     }
}