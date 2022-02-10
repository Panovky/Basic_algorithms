"use strict";


// 1. Базовый алгоритм Евклида вычитанием


function gcd_11(a, b) {  // рекурсивная реализация

    if (a == b) {
        return a  // искомый нод
    }

    if (a > b) {
        return gcd_11(a - b, b)
    } else {
        return gcd_11(a, b - a)
    }
}


function gcd_12(a, b) {  // реализация с использованием цикла while

    while (a != b) {
        if (a > b) {
            a = a - b
        } else {
            b = b - a
        }
    }

    return a  // искомый НОД
}



// 2. Базовый алгоритм Евклида делением


function gcd_21(a, b) {  // рекурсивная реализация (число a больше числа b)

    if (b == 0) {  // меньшее число пары равно нулю - база рекурсии
        return a  // искомый НОД
    }

    return gcd_21(b, a % b)
}


function gcd_22(a, b) {  // реализация с использованием цикла while (число a больше числа b)

    while (b != 0) {
        [a, b] = [b , a % b]  // деструктурирующее присваивание
    }

    return a  // искомый НОД
}



// 3. Расширенный алгоритм Евклида


function gcd_3(a, b) {  // рекурсивная реализация (число a больше числа b)

    if (b == 0) {  // база рекурсии

        return [a, 1, 0]  // НОД = a, x = 1, y = 0
    }

    let [g, x1, y1] = gcd_3(b, a % b)  // ищем коэффициенты для следующей пары чисел

    return [g, y1, x1 - (a / b) * y1] // возвращаем коэффициенты для текущей пары чисел
}