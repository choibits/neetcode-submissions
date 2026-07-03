class Solution {
    // min heap
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // priority queue
        // loop through the nums, add to a hashmap
        // key as number, value as frequency
        // loop through the values of the hashmap and add to the queue
        // pop k values from the queue and get the key that has that value

        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        // pop off min heap until its k numbers
        for ((num, count) in map) {
            minHeap.add(Pair(num, count))
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        // add the numbers to an array to return
        // by popping from the minheap

        // create array
        val res = IntArray(k)
        // cycle through minheap with index
        for (i in k - 1 downTo 0) {
            // add to array with index, pop from minHeap the first number
            res[i] = minHeap.poll().first
        }
        return res

    }
}
