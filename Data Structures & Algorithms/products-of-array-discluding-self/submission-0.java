class Solution {
    public int[] productExceptSelf(int[] nums) {

        int countOfZero = 0;
        for( int num : nums ) {
            if(num==0) ++countOfZero;
        }

        if(countOfZero > 1){
            for(int i=0 ; i < nums.length ; i++){
                nums[i]=0;
            }
            return nums;
        }

        int[] postFix = new int[nums.length];
        postFix[nums.length-1] = nums[nums.length-1];
           // System.out.println( postFix[nums.length-1] );

        for(int i = nums.length-2; i >= 0; --i){
            postFix[i] = nums[i]*postFix[i+1];
           // System.out.println(postFix[i]);
        }

        int runningPrefix = nums[0];
        System.out.println(runningPrefix);

        if(nums.length > 1) nums[0]=postFix[1];
        int currNumber = 0;

        for(int i=1; i < nums.length; i++){
            currNumber = nums[i];

             if( i+1 < nums.length)
                nums[i] = runningPrefix * postFix[i+1];
            else 
                nums[i] = runningPrefix;

            runningPrefix *= currNumber;
            System.out.println(runningPrefix);
        }

        return nums;
    }
}  
