class Solution {

    fun encode(strs: List<String>): String {

        // loop through the strings. on each loop,
        // get the length of the string, 
        // then use a separator and then add the string to the final string. 

        // final string to join to stored
        val sb = StringBuilder()
        for (s in strs) { // O(m) if m is length of strs 
            // this works but Kotlin strings are immutable, so they can't be modified in place
            // encodedString += s.length + "#" + s
            // better to use string builder
            sb.append(s.length)
            sb.append("#")
            sb.append(s)
        }   
        return sb.toString() // O(n) if n is length of the string
    }

    fun decode(str: String): List<String> {
        // the list
        val res = mutableListOf<String>()
        var i = 0
        // for every character
        // 4#neet4#code
        // can't just loop through the characters
        // need the index for the stopping point

        // note: can't use a for loop here 
        // need the WHILE loop so the i variable is not a val
        while (i < str.length) {
            // pointer 
            var j = i
            while (str[j] != '#') {
                j++
            }
            // cut the string to only show length
            // note substring the start index is inclusive
            // the end index is exclusive
            val length = str.substring(i,j).toInt()
            // get the word substring
            // start at after the pound,so j+1 and then go to length
            val word = str.substring(j+1, j+ 1+ length)
            // add to the list
            res.add(word)
            // re point the pointer at the last character
            i = j+ 1 + length
            
        }
        return res
    }
}
