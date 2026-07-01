class Solution {
    // You could use a HashMap to store the letters in. 
    // When looping through the string, you first want to store the letters and their counts. 
    // And on the second loop, you'd want to subtract from the counts. 
    // Then you check if there is any value that is greater than zero in the hashmap.
    fun isAnagram(s: String, t: String): Boolean {
        // maps need to be mutable
        val map = mutableMapOf<Char, Int>()
        // string length check - if diff than not anagram
        if (s.length != t.length) return false
        // one way to make it more efficient
        // It could be to loop through the two strings at the same time.

        // first loop add counts to map
        for (c in s) {
            map[c] = map.getOrDefault(c,0) +1
        } 

        // second loop through for c in t... 
        for (c in t) {
            if (!map.containsKey(c)) return false
            // need to mark non null for kotlin
            map[c] = map[c]!! - 1
            if (map[c] == 0) {
                map.remove(c)
            }
        }
        //instead of returning true
        return map.isEmpty()
    }
}
