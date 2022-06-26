public class ClimbStairsWithMinCost {

    public static int solve (int n , int[] cost){
        if(n==0 || n==1)
        return cost[n];

        return Math.min(solve(n-1, cost),solve(n-2, cost))+cost[n];
        
    }

    public static int solve2(int n , int[] cost,int[] dp){
        if(n==0 || n==1)
        return cost[n];

        dp[n]=Math.min(solve2(n-1, cost,dp),solve2(n-2, cost,dp))+cost[n];
        return dp[n];
    }

    public static int ClimbStairsWithMinCostUsingRecursion(int n,int[] cost) {
    return Math.min(solve(n-1,cost), solve(n-2, cost));
    }

    public static int ClimbStairsWithMinCostUsingMemoization(int n, int cost[],int[] dp) {
        
        return Math.min(solve2(n-1,cost,dp),solve2(n-2, cost, dp));
    }

    public static int ClimbStairsWithMinCostUsingTabulation(int n, int cost[],int dp[]){
        dp[0]= cost[0];
        dp[1]=cost[1];

        for(int i=2;i<dp.length;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        
        return Math.min(dp[n-1],dp[n-2]);
    }

    public static int ClimbStairsWithMinCostUsingNoSpace(int n , int cost[]) {
        int prev2=cost[0];
        int prev1 = cost[1];
        for(int i=2;i<n;i++){
            int current = Math.min(prev1,prev2)+cost[i];
            prev2=prev1;
            prev1 = current;
        }

        return Math.min(prev1,prev2);
    }

    public static void main(String[] args) {
        int arr[]= {1,100,1,1,1,100,1,1,100,1};
        int n = arr.length;
        //Recursion
        int Rec =ClimbStairsWithMinCostUsingRecursion(n,arr);
        System.out.println("Recursion "+Rec);
        //Memoiization
        int dp[] =new int[n+1];
        int Mem = ClimbStairsWithMinCostUsingMemoization(n,arr,dp);
        System.out.println("Memoization "+Mem);
        //Tabulation
        int dp2[] = new int[n];
        int Tab = ClimbStairsWithMinCostUsingTabulation(n,arr,dp2);
        System.out.println("Tabulation "+Tab);
        //solution using O(1) space
        int NoSpaceSolution = ClimbStairsWithMinCostUsingNoSpace(n, arr);
        System.out.println("No space "+NoSpaceSolution);
    }
}