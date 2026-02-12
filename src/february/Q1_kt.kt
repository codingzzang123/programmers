package february

// 문자열 내 마음대로 정렬하기
class Q1_kt {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.also {
            it.sort()
            it.sortBy { it[n] }
        }
    }

    fun solution_1(strings: Array<String>, n: Int): Array<String> {
        var answer = strings

        var list =  answer.sortedWith(compareBy({ it[n] }, { it }))
        return list.toTypedArray()
    }

    fun solution_3(strings: Array<String>, n: Int): Array<String> {

        strings.sortWith(Comparator<String> { a, b ->
            when {
                a[n] > b[n] -> 1
                a[n] == b[n] -> {
                    when {
                        a > b -> 1
                        else -> -1
                    }
                }
                else -> -1
            }
        })
        return strings
    }

    fun solution_4(strings: Array<String>, n: Int): Array<String> {
        return strings.sortedWith(Comparator<String> { s1, s2 ->
            when (s1[n] == s2[n]) {
                true -> s1.compareTo(s2)
                false -> s1[n].compareTo(s2[n])
            }
        }).toTypedArray()
    }
}