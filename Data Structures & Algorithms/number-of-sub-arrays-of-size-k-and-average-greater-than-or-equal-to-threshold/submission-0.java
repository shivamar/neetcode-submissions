class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int tot=0, numOfSubarrays=0;

        for(int l=0;l < arr.length-k+1;l++){
            int r=l;
            tot=0;
            while(r < l+k){
                tot += arr[r];
                r++;
            }

            if(tot/k >= threshold) numOfSubarrays++;
        }

        return numOfSubarrays;
    }
}