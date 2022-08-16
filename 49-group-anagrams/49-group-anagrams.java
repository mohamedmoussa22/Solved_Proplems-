class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortedString = sortString(strs[i]);
            if (map.containsKey(sortedString))
                map.get(sortedString).add(strs[i]);
            else {
                map.put(sortedString, new ArrayList<String>());
                map.get(sortedString).add(strs[i]);
            }

        }

        for (String x : map.keySet()) {
            ans.add(map.get(x));
        }

        return ans;
}
    
        public static String sortString(String inputString) {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
}