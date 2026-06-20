class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i < strs.size(); i++)
        {
            result.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> li = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiter));
            i = delimiter + 1;
            li.add(str.substring(i, i + length));
            i += length;
        }
        return li;
    }
}