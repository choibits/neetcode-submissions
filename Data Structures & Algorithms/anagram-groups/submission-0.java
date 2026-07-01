class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // if list is empty, return an empty list of lists
        // if list has only one string with one letter, 
        // then return list of list with just the one letter

        // how would i be able to check if it's an actual word...?
        // in this case, leetcode does not care if it is an actual word

        // initialize hashmap to store diff word combos
        // String will be key, and List of strings is what you'll be returning
        Map<String, List<String>> map = new HashMap<>();
        // key: signature, value: list of strings that share the word

        // loop through list of strings
        for (int i = 0; i < strs.length; i++) {
            // STEP 1. take one of strings[i] and put it in a diff order 
            // i.e. sorted char array -> new string
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // STEP 2. check if signature exists in map
            // if not create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>()); // creates new list
            }

            // STEP 3. append original word to that list?
            // map.put(key, strs[i]); WRONG WAY - can get list and chain
            map.get(key).add(strs[i]);

            // could start with second letter first?
            // loop within a loop, but this could be inefficient
        }

        // return a list of a list of strings in any order
        return new ArrayList<>(map.values());

    }
}
