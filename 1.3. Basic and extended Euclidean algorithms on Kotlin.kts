// 1. Базовый алгоритм Евклида вычитанием


fun gcd_11(a: Int, b: Int): Int {  // рекурсивная реализация

    if (a == b) {
        return a  // искомый НОД
    }

    if (a > b) {
        return gcd_11(a - b, b)
    } else {
        return gcd_11(a, b - a)
    }
}


fun gcd_12(a: Int, b: Int): Int {  // реализация с использованием цикла while

    var array = arrayListOf<Int>(a, b)

    while (array[0] != array[1]) {
        if (array[0]  > array[1]) {
            array = arrayListOf<Int>(array[0] - array[1], array[1])
        } else {
            array = arrayListOf<Int>(array[0], array[1] - array[0])
        }
    }

    return array[0]  // искомый НОД
}



// 2. Базовый алгоритм Евклида делением


fun gcd_21(a: Int, b: Int): Int {  // рекурсивная реализация (число a больше числа b)

    if (b == 0) {  // одно из чисел пары равно нулю - база рекурсии
        return a  // другое является НОД
    }

    return gcd_21(b, a % b)
}


fun gcd_22(a: Int, b: Int): Int {  // реализация с использованием цикла while (число a больше числа b)

    var array = arrayListOf<Int>(a, b)

    while (array[1] != 0) {
        array = arrayListOf<Int>(array[1], array[0] % array[1])
    }

    return array[0]  // искомый НОД
}


// 3. Расширенный алгоритм Евклида


fun gcd_3(a: Int, b: Int): ArrayList<Int> {  // рекурсивная реализация (число a больше числа b)

    if (b == 0) {  // база рекурсии
        var array = arrayListOf<Int>(a, 1, 0)
        return array  // НОД = a,  x = 1, y = 0
    }

    var array = gcd_3(b, a % b)  // ищем коэффициенты для следующей пары чисел
    var g: Int = array[0]
    var x1: Int = array[1]
    var y1: Int = array[2]

    array = arrayListOf<Int>(g, y1, x1 - (a / b) * y1)
    return array  // возвращаем коэффициенты для текущей пары чисел
}
