public class Fibonacci{
    
    
    public static int FibonacciUsingRecursion(int n){
        if(n==0 || n==1) return n;
        return FibonacciUsingRecursion(n-1)+FibonacciUsingRecursion(n-2);
    }

    public static int FibonacciUsingMemoization(int n , int[] dp) {
        if(n==0 || n==1) return n;
        dp[n] = FibonacciUsingMemoization(n-1, dp) + FibonacciUsingMemoization(n-2, dp);
        return dp[n];
    }

    public static int FibonacciUsingTabulation(int n ,int[] dp) {
        dp[0] =0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int TabulationWithoutSpace(int n) {
        int dpPrev=0;
        int dpNext=1; 
        int temp=0; 
        while((n-1)>0){
             temp=dpPrev+dpNext;
            dpPrev=dpNext;
            dpNext= temp;
            n--;
        }
            return temp;        
    }
    
    public static void main(String[] args) {
    int n=10;
    System.out.println("Recursion "+FibonacciUsingRecursion(n)); //TIME - O(N)+O(N)   AND SPACE - O(N)
    int dp[] = new int[n+1];
    System.out.println("Memoization "+FibonacciUsingMemoization(n,dp));  //TIME - O(N) AND SPACE - O(N)
    int dpt[] = new int[n+1];
    System.out.println("Tabulation "+FibonacciUsingTabulation(n,dpt)); // TIME - O(N) SPACE O(N)
    System.out.println("Tabulation without Space "+TabulationWithoutSpace(n)); // TIME -O(N) SPACE - O(1)
    }
}