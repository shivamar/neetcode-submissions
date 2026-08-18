class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] arr=new int[2];
        arr[0]=1;
        arr[1]=2;
        int result=0;

        for(int i=3; i<=n;i++)
        {
          result=arr[0]+arr[1];
          arr[0]=arr[1];
          arr[1]=result;
        }

        return result;
    }
}
