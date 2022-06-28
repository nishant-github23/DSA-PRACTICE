public class MinimumSumOfNonAdjacentElement {
    
    public static int MinimumSumOfNonAdjacentElementUsingRec(int arr[] , int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return arr[0];
        }

        int inc = arr[n] + MinimumSumOfNonAdjacentElementUsingRec(arr, n-2);
        int exc = MinimumSumOfNonAdjacentElementUsingRec(arr, n-1);

        return Math.max(inc , exc);
    }

    public static int MinimumSumOfNonAdjacentElementUsingMem(int arr[] , int n , int dp[]) {
       if(n<0) return 0;

       if(n==0){
       return arr[0];
       }

       if(dp[n]!=-0)
       return dp[n];

       int inc = arr[n] + MinimumSumOfNonAdjacentElementUsingMem(arr, n-2, dp);
       int exc = MinimumSumOfNonAdjacentElementUsingMem(arr, n-1, dp);

       dp[n] = Math.max(inc, exc);

       return dp[n];

    }

    public static int MinimumSumOfNonAdjacentElementUsingTab(int arr[] , int n , int dp[]){
        dp[0] =arr[0];
        
        for(int i=2;i<arr.length;i++){
            int inc = arr[i] + dp[i-2];
            int exc = dp[i-1];
            dp[i] = Math.max(inc,exc);
        }

        return dp[n];

    }

    public static int MinimumSumOfNonAdjacentElementUsingConstSpace(int arr[] , int n) {
        
        int prev2= arr[0];
        int prev1=0;
        for(int i=2;i<arr.length;i++){
            int inc = arr[i]+ prev2;
            int exc= prev1;
            int ans= Math.max(inc,exc);
            prev2 =prev1;
            prev1= ans;
        }
        return prev1;
    }


    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,6,8};
        int n = arr.length;
        System.out.println(MinimumSumOfNonAdjacentElementUsingRec(arr,n-1));
        int dp[] = new int[n];
        // System.out.println(MinimumSumOfNonAdjacentElementUsingMem(arr,n-1,dp));
        System.out.println(MinimumSumOfNonAdjacentElementUsingTab(arr,n-1,dp));
        System.out.println(MinimumSumOfNonAdjacentElementUsingConstSpace(arr,n-1));
    }
}
