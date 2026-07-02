class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // If I were to only use a single array of 26 characters, how would I do this? 
        // 26 characters in an array, add 1 if you see that character in the string
        // to the appropriate index that represents that character
        // key would be the array, values would be the lists 
        val map = HashMap<String, MutableList<String>>()

        for (s in strs) {
            // create a array of length 26 of integers (all 0)
            val arr = IntArray(26)

            // loop through individual characters in string and represent as array
            for (c in s) {
                arr[c - 'a']++
            }
            // make that array into an anagram key
            val key = arr.joinToString(",")

            map.getOrPut(key) { mutableListOf() }.add(s)
        }
        // Need to return the map VALUES as a list, not the whole map. 
        return map.values.toList()
    }
    // Time complexity would be O(nk)
    // Space complexity would be O(nk)
    // * n = number of strings in the input array
    // * k = average length of each string

    // you might think we're creating fixed size arrays so the space would be O(1)
    // but that's for the temporary array
    // the hashmap would store every grouped string
}
