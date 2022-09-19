import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumber {
    private final static TreeMap<Integer, String> romeArab = new TreeMap<>();

    static {                                                                                                            //floorKey(K obj) : возвращает самый большой ключ k, который меньше или равен ключу obj. Если такого ключа нет, возвращает null; поэтому разделяем число по разрядам 1000, след 900, след 500 (следующее римское число по убыванию) и тд (смотри элементы romeArab)

        romeArab.put(1000, "M");
        romeArab.put(900, "CM");
        romeArab.put(500, "D");
        romeArab.put(400, "CD");
        romeArab.put(100, "C");
        romeArab.put(90, "XC");
        romeArab.put(50, "L");
        romeArab.put(40, "XL");
        romeArab.put(10, "X");
        romeArab.put(9, "IX");
        romeArab.put(5, "V");
        romeArab.put(4, "IV");
        romeArab.put(1, "I");

    }
    public static String convertertoroman(int number) {
        int l =  romeArab.floorKey(number);
        if ( number == l ) {
            return romeArab.get(number);
        }
        return romeArab.get(l) + convertertoroman(number-l);
    }
    static int convertertoarab(char[] romannumber){                                                                     //для римских чисел в арабские достаточно алфавита по символам римского счисления и начинаяс самого левого числа, если элемент больше чем справа то его значение (X = 10 например) прибавить к результату, если меньше (IX = -1 + 10) то вычесть

        Map<Character,Integer> arabRome = new HashMap<>();
        arabRome.put('I',1);
        arabRome.put('V',5);
        arabRome.put('X',10);
        arabRome.put('L',50);
        arabRome.put('C',100);
        arabRome.put('D',500);
        arabRome.put('M',1000);
        int number = 0;
        for (int i = 0; i < romannumber.length-1; i++) {
            if (arabRome.get(romannumber[i]) < arabRome.get(romannumber[i+1])){
                number -=  arabRome.get(romannumber[i]);
            }
            else{
                number += arabRome.get(romannumber[i]);
            }
        }
        number += arabRome.get(romannumber[romannumber.length-1]);
        return (number);
    }
}