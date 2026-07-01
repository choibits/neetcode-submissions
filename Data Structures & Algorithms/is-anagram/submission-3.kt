class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        // the other way is to use a fixed size array for every letter
        // vs. a mutable list
        if (s.length != t.length) return false
        val count = IntArray(26)

        for (i in s.indices) {
            count[s[i] - 'a']++
            count[t[i] - 'a']--
        }
        for (num in count) {
            if (num != 0) return false
        }
        return true
        // Time complexity is O(1), and the space complexity is O(n). 
    }
}

// So the reason why this works is because it creates an array of 26 letters. 
// And when using Unicode values, you can subtract A from any letter, and that distance from A will be unique. 
// Since it is unique, you know that you are adding to the count and subtracting from the count for a unique index. 
// Kotlin uses Unicode for characters because it is a more modern version that allows for other languages, not just the ASCII characters. 
// To each have a unique code 