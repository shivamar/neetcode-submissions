class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,maxLen=0;
        Set<Character> set = new HashSet<Character>();

        for(int r=0; r<s.length(); r++){
            if (!set.contains(s.charAt(r))){
                set.add(s.charAt(r));

            } else {
                while(r>l && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                   set.add(s.charAt(r));
            }

            maxLen = Math.max(r-l+1,maxLen);
        }

        return maxLen;

    }
}
