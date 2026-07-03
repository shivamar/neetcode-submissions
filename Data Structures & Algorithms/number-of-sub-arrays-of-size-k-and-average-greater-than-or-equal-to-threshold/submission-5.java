class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int tot=0, numOfSubarrays=0;

        int r=0;
        for(int l=0;l < arr.length-k+1;l++){
            if(l==0) 
                r=l;

          //  tot=0;

            if(l==0) {
                while(r < l+k){
                    tot += arr[r];
                    r++;
                }
            }
            else {
                //add the last number r but remove the number number l , i.e l-1 where r is k+l window
                tot+=arr[r];
                r++;
                tot-=arr[l-1];
            }

            if(tot/k >= threshold) numOfSubarrays++;
        }

        return numOfSubarrays;
    }
}