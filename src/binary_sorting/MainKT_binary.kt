import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)


    val n = scanner.nextInt()
    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
    }

    val swaps = mutableListOf<String>()

    var left = 0
    var right = n - 1


    while (left < right) {
        while (arr[left] == 0 && left < right) {
            left++
        }
        while (arr[right] == 1 && left < right) {
            right--
        }

        if (left < right) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp

            swaps.add("$left $right")
            left++
            right--
        }
    }

    println(swaps.size)
    swaps.forEach { println(it) }
}
