import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val l = scanner.nextInt()
    val r = scanner.nextInt()

    println(getSum(n, l, r))
}

// Рекурсивный метод для вычисления суммы элементов на интервале [l, r]
fun getSum(n: Int, l: Int, r: Int): Long {
    if (l > r) return 0
    if (n == 1) return 1 // T1 = [1]

    val lenPrev = (1 shl (n - 1)) - 1 // Длина T[n-1]

    var sum = 0L

    // 1. Если часть интервала лежит в первом T[n-1]
    if (l < lenPrev) {
        sum += getSum(n - 1, l, minOf(r, lenPrev - 1))
    }

    // 2. Если центральный элемент n входит в интервал
    if (l <= lenPrev && r >= lenPrev) {
        sum += n
    }

    // 3. Если часть интервала лежит во втором T[n-1]
    if (r > lenPrev) {
        sum += getSum(n - 1, maxOf(0, l - lenPrev - 1), r - lenPrev - 1)
    }

    return sum
}
