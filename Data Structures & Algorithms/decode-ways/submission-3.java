class Solution {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numDecodings(String s) {
        //11106 -> 1, 1 ,10, 6 |  11 , 10 , 6  

        char[] charArr = s.toCharArray();
        map = new HashMap<Integer, Integer>();
        return helper(charArr, 0);
    }

    public int helper(char[] charArr,int curr)
    {
        int count=0;
        if(curr == charArr.length) return 1; // no invalid reached til end of char
        if(charArr[curr] == '0') return 0; //valdiity check

        if(map.containsKey(curr)) return map.get(curr);

        //System.out.println(curr+" "+charArr[curr]);
        count += helper(charArr,curr+1);  // check next char

        if(curr+1 < charArr.length && (Integer.valueOf(""+charArr[curr]+charArr[curr+1]) > 9 && Integer.valueOf(""+charArr[curr]+charArr[curr+1]) < 27)) 
            count += helper(charArr,curr+2); //check next char if 2 digits are valid

        map.put(curr, count);

        return count;
    }
}
