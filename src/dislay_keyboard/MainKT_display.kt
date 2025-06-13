import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    scanner.useLocale(Locale.US)

    val keyboard = Array(4) { Array(10) { "" } }
    val input = scanner.next()
    val chars = input.toCharArray()



    keyboard[0][0] = "0"
    keyboard[0][1] = "1"
    keyboard[0][2] = "2"
    keyboard[0][3] = "3"
    keyboard[0][4] = "4"
    keyboard[0][5] = "5"
    keyboard[0][6] = "6"
    keyboard[0][7] = "7"
    keyboard[0][8] = "8"
    keyboard[0][9] = "9"

    var pointer = 0
    for (i in 0 until 10) {
        keyboard[1][i] = chars[pointer].toString()
        pointer++
    }
    for (i in 0 until 10) {
        keyboard[2][i] = chars[pointer].toString()
        pointer++
    }

    keyboard[3][0] = chars[pointer].toString()
    pointer++
    keyboard[3][1] = chars[pointer].toString()
    pointer++
    keyboard[3][2] = chars[pointer].toString()
    pointer++
    keyboard[3][7] = chars[pointer].toString()
    pointer++
    keyboard[3][8] = chars[pointer].toString()
    pointer++
    keyboard[3][9] = chars[pointer].toString()
    keyboard[3][3] = " "
    keyboard[3][4] = " "
    keyboard[3][5] = " "
    keyboard[3][6] = " "

    var finalString = ""

    for (i in 0 until n) {
        val x = scanner.nextDouble()
        val y = scanner.nextDouble()


        val xK = Math.floor(x).toInt()
        var yK = Math.floor(y).toInt()

        // Изменяем координату y
        yK = 3 - yK


        finalString += keyboard[yK][xK]
    }

    println(finalString)
}
