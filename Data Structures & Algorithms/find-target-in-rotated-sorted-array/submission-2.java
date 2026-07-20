class Solution {
    public int search(int[] nums, int target) {
       int l=0,r=nums.length-1,mid=0,pivot=0;

       if(nums.length==0) return -1;
       if(nums.length==1){
         return binarySearch(nums,0,nums.length-1,target);
       } 

//find smallest number pivot 
       while(r>l){
        
        mid=l+(r-l)/2;
        if(nums[mid] < nums[l]){
            r=mid;
        }
        else if(nums[mid] > nums[r]){
            l=mid+1;
        } else {
            pivot=l;
            break;
        }
       } 

       pivot = l;

       if(nums[0] < nums[nums.length-1]) return binarySearch(nums,0,nums.length-1,target);

        int res = binarySearch(nums,0,l-1,target);
        if(res == -1) res = binarySearch(nums,l, nums.length-1,target);

        return res;
    }

    private int binarySearch(int[] nums, int l, int r, int target){

       int res = Arrays.binarySearch(nums,l,r+1,target);
       if(res < 0) return -1;
       return res;
    }
}
