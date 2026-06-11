class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start=0;
         Map<Character, Integer> state = new HashMap<>(); 

         for(char c : s1.toCharArray()){
            state.put(c, state.getOrDefault(c, 0)+1);
         }

         for(int end=0;end < s2.length();end++){
            char current = s2.charAt(end);
            if(state.containsKey(current))
            {
                 Map<Character, Integer>  deepCopy = new HashMap<>(state);
                 int tempEnd = end;

                 while(tempEnd < s2.length() && tempEnd - end < s1.length()){
                    char c = s2.charAt(tempEnd);
                    if(deepCopy.getOrDefault(c, 0) > 0){
                        deepCopy.put(c, deepCopy.get(c) - 1);
                        if(deepCopy.get(c) == 0) deepCopy.remove(c);
                    } else {
                        break;
                    }
                    tempEnd++;
                 }
                 if(deepCopy.isEmpty() ) return true;
            }
         }
         return false;

    }
}