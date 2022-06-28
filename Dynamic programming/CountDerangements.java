public class CountDerangements {

    public static int CountDerangementsUsingRec(int n){
        //base case
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        int ans = (n-1)*(CountDerangementsUsingRec(n-1)+CountDerangementsUsingRec(n-2));

        return ans;
    }

    public static int CountDerangementsUsingMem(int n , int dp[]){
        if(n==1){
           return 0;
        }
        if(n==2){
            return 1;
        }

        dp[n] = (n-1)*(CountDerangementsUsingMem(n-1, dp)+CountDerangementsUsingMem(n-2, dp));
        
        return dp[n];
    }
    
    public static int CountDerangementsUsingTab(int n , int[] dpTab) {

         dpTab[1]=0;
         dpTab[2]=1;
        for(int i=3;i<=n;i++){
        dpTab[i] = (i-1)*(dpTab[i-1]+dpTab[i-2]);
        }
        return dpTab[n];
    }
    
    public static int CountDerangementsUsingConstSpace(int n){
        int prev1=0;
        int prev2=1;
        int temp=0;
        for(int i=3;i<=n;i++){
            temp=prev2;
            prev2 = (i-1)*(prev1+prev2);
            prev1= temp;
        }
        return prev2;
    }
    
    public static void main(String[] args) {
        int n =4;
    //   System.out.println(CountDerangementsUsingRec(n));
      int dp [] = new int[n+1];
    //   System.out.println(CountDerangementsUsingMem(n,dp));
    int dpTab [] = new int[n+1];
    //   System.out.println(CountDerangementsUsingTab(n, dpTab));
    System.out.println(CountDerangementsUsingConstSpace(n));
  
    }
}
