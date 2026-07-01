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
