class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // list to hold the result
        // val res = mutableListOf(List<Str>())

        // hash map will have a SORTED key and a list
        val map = HashMap<String, MutableList<String>>()

        // loop through all the strings
        for (s in strs) {
            // can't just do s.sort()..
            // the map key needs to be a joined string after it's been sorted by character
            val key = s.toCharArray().sorted().joinToString("")

            map.getOrPut(key) { mutableListOf() }.add(s)
            // get or put is shorthand for

            // if (!map.containsKey(key)) {
                // map[key] = mutableListOf()
            // }
            // map[key]!!.add(str)

        }
        return map.values.toList()



        // create a map with the counts of each character per string
        // if the map created is equal to the next string add it to a list
        // add the list to the result list

        //return res
    }
}
