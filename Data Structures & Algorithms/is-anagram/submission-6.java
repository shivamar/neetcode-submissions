class Solution {
 
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length() ) return false;

        HashMap<Character, Integer> mapA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapB = new HashMap<Character, Integer>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int bVar=0, countA=0 , countB=0;

        for(char a :  s1){
            char b = t1[bVar++];

            if(mapA.get(a)== null) {
                mapA.put(a, 1);
            } else {
                countA = mapA.get(a);
                mapA.put(a, ++countA);
            }

            if(mapB.get(b)== null) {
                mapB.put(b, 1);
            } else {
                countB = mapB.get(b);
                mapB.put(b, ++countB);
            }
        }

        //iterate the map and check if the count of each character is the same in both maps
        for(char a : mapA.keySet()){
            if(mapB.get(a) == null || !Objects.equals(mapB.get(a), mapA.get(a))) return false;
        }

        return true;
    }
}