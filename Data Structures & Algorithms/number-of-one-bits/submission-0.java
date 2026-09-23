class Solution {
    public int hammingWeight(int n) {
        int bitMask = 1,count=0;

        while(n > 0){
            int temp = bitMask & n;
            if(temp == 1){
                count++;
            }
            n=n>>>1;
        }

        return count;
    }
}
