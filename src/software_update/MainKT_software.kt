
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val d = IntArray(n)
    val s = IntArray(n)
    val graph = Array(n) { mutableListOf<Int>() }

    for (i in 0 until n) {
        d[i] = scanner.nextInt()
    }
    for (i in 0 until n) {
        s[i] = scanner.nextInt()
    }

    // Считываем граф обновлений
    for (i in 0 until n) {
        val k = scanner.nextInt()
        repeat(k) {
            graph[i].add(scanner.nextInt() - 1)
        }
    }

    val queue: Queue<Pair<Int, Long>> = ArrayDeque()
    queue.add(0 to d[0].toLong())

    var maxTime = 0L

    while (queue.isNotEmpty()) {
        val (phone, time) = queue.poll()

        maxTime = maxOf(maxTime, time)

        var curTime = time
        for (next in graph[phone]) {
            curTime += maxOf(s[phone], d[next])
            queue.add(next to curTime)
        }
    }

    println(maxTime - d[0])
}
