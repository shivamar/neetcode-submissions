class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupAnagrams = new HashMap<String, List<String>> ();

        for(String str : strs){
           int[] alphabetArr = new int[26];
           char[] charArr = str.toCharArray();
           
           for(char c : charArr){
               alphabetArr[c - 'a']++;      
           }

           String key = Arrays.toString(alphabetArr);

           if(groupAnagrams.get(key)!=null){
                groupAnagrams.get(key).add(str);
           }
           else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                groupAnagrams.put(key, list);
           }

        }

        List<List<String>> result = new ArrayList<>(groupAnagrams.values());

        return result;

    }
}