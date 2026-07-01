class Solution {
    public boolean isAnagram(String s, String t) {
        // LEARNINGS:
        // .length is a property for arrays, but .length() is for String objects
        // For generic types, use Character vs Char
        // Use .getOrDefault otherwise when you first are getting for a character that isn't stored yet
        // it will return null
        // remember to use .equals() for comparing two maps to each other, sCounts == tCounts 
        // would check object identity


        // edge cases
        // if the lengths are different, then they are not anagrams
        if (s.length() != t.length()) return false;
        // not sure how they might want to handle empty string...
        // but seems s and t will at least always have lowercase letters according to constraints

        // checking if it's an anagram
        // store counts in a hashmap
        
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> tCounts = new HashMap<>();

        // loop through String s and t and store counts
        for (int i = 0; i < s.length(); i++) {
            sCounts.put(s.charAt(i), sCounts.getOrDefault(s.charAt(i),0)+1);
            tCounts.put(t.charAt(i), tCounts.getOrDefault(t.charAt(i),0)+1);
        }

        if (sCounts.equals(tCounts)) return true;
        return false;

        // return a boolean
        // if they are equal, then return true, else return false
        // another way to do this would be if there's a char that doesn't exist in the
        // second string you could do an easy return false (early exit)
        
    }
}
