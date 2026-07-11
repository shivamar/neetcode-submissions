class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int curr = 0;
        Set<Character> openSet = new HashSet<Character>();
        Arrays.asList('(', '{', '[').forEach(openSet::add);

        Map<Character, Character> bracketsMap = new HashMap<Character, Character>();
        // bracketsMap.put('(',')');
        // bracketsMap.put('{','}');
        // bracketsMap.put('[',']');

        bracketsMap.put(')','(');
        bracketsMap.put('}','{');
        bracketsMap.put(']','[');
        Character c = null;

        while( curr < s.length()){
            if( openSet.contains(s.charAt(curr)) ){
                stack.push(s.charAt(curr));
            }
            if( bracketsMap.containsKey(s.charAt(curr)) ){
                if(stack.size()>0)  c = stack.peek();
                else return false;

               if(bracketsMap.get(s.charAt(curr)).equals(c)){
                stack.pop();
               }
               else return false;
            }
            curr++;
        }
        
        return stack.size() == 0;
    }
}
