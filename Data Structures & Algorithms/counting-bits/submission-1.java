class Solution {

    public int[] countBitsOld(int n) {
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
            k = bitMask & num; // take stock of which element is present in each bit at 0th place
            if(k == 1) count++;
            num = num >> 1; //right shift number so you move the next bit to units place
        }

        return count;
    }
        public int[] countBits(int n) {
            int[] output = new int[n+1];
            output[0]=0;



            for(int i=1; i<=n;i++)
            {
                output[i]=output[i>>1] + (i & 1);
            }

            // int a = output[3 >> 1] + (3 & 1);

            // System.out.println(a);

            // int b = 3 & 1;
            // System.out.println(b);
            //  System.out.println(a+b);

            return output;
    }
}
