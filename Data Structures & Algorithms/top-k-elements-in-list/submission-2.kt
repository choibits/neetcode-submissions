class Solution {
    // HASHMAP
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // hash map to track the integer as key, frequency as value
        val map = HashMap<Int, Int>()
        val res = mutableListOf<Int>()
        // loop through the numbers
        // get the frequency count as a key in the hash map
        // O(n)
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        // create an array called buckets where the index represents the frequency
        // empty list in each index
        //O(n+1)
        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }

        // put each number into its frequency bucket
        // O(m unique elements), each insert is O(1)
        for ((num, count) in map) {
            buckets[count].add(num)
        }

        // go backwards in the array to know the most frequent elements
        // by reversing the array
        // O(n). to scan all indices
        for (i in buckets.indices.reversed()) {
            for (num in buckets[i]) {
                res.add(num)
                // if the list now has k elements just return it
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }
        // return empty array
        return res.toIntArray()

    }
}

// time complexity: O(n+m) -> O(n)
// n being the size of nums, m being the number of unique elements in nums
// space complexity: O(m) for the has map, buckets are O(n) -> O(n)
