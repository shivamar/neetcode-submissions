class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n+1];

        for(int i=0; i<=n;i++)
        {
            output[i]=findBitCount(i);
        }

        return output;
    }


    public int findBitCount(int num){
        int bitMask = 1, count=0,k=0;

        while(num > 0)
        {
            k = bitMask & num;
            if(k == 1) count++;
            num = num >> 1;
        }

        return count;
    }
}
