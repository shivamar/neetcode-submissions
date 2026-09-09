class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordListSet  = new HashSet<>(wordList);
        if(! wordListSet.contains(endWord)) return 0;

        HashMap<String, List<String>> indexPatternWList = new HashMap<String, List<String>>();
        for(String word : generatePatterns(beginWord) ){
            indexPatternWList.computeIfAbsent(word, x-> new ArrayList<String>()).add(beginWord);
        }

        for(String word : wordList){
            for(String pattern : generatePatterns(word) )
                indexPatternWList.computeIfAbsent(pattern, x-> new ArrayList<String>()).add(word);
        }

        ArrayDeque<String> arrayDeq = new ArrayDeque<String>();
        Set<String> visited = new HashSet<>();
        arrayDeq.offer(beginWord);
        visited.add(beginWord);
      

        //BFS
        int level = 0;
        while(!arrayDeq.isEmpty()){
            int size = arrayDeq.size();
            for(int k=0;k < size;k++)
            {
                String word = arrayDeq.poll();
                
                
                if(word.equals(endWord)) return level+1;

                for(String patt :  generatePatterns(word))
                {
                    List<String> nextWords = indexPatternWList.get(patt);
                    for(String nextWord : nextWords){
                        if(visited.contains(nextWord)) continue;
                        arrayDeq.add(nextWord);
                        visited.add(nextWord);
                    }
                }

            }
            level++;
        }

        return 0;
        
    }

    private String[] generatePatterns(String word){
        String[] wordPatterns = new String[word.length()];
        char[] charArr = new char[word.length()];

        for(int i=0; i < word.length();i++){
            charArr = word.toCharArray();
            charArr[i]='*';
            wordPatterns[i]=String.valueOf(charArr);
        }

        return wordPatterns;
    }
}
