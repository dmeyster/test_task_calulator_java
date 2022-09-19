
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expressioninput = in.nextLine();
        System.out.println(calc(expressioninput));                                                                      //вызываем калькулятор
    }
    public static String calc(String expression) {
        String[] splitedexpression = expression.split(" ");                                                       //разделяем входную строку на части по пробелам должны получится два числа и знак операции

        try{                                                                                                            //try и parseint помогают определить число арабское или римское если оба арабские то смотри строку 20 если оба римские смотри строку 47
            int number1 = Integer.parseInt(splitedexpression[0]);
            if ((number1 < 0)||(number1 > 10)){                                                                         //Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
                return("throws Exception");
            }
            try {
                int number2 = Integer.parseInt(splitedexpression[2]);
                if ((number2 < 0)||(number2 > 10)){                                                                     //Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
                    return("throws Exception");
                }
                if ("+".equals(splitedexpression[1])){
                    return (String.valueOf(number1 + number2));
                }
                if ("-".equals(splitedexpression[1])){
                    return (String.valueOf(number1 - number2));
                }
                if ("*".equals(splitedexpression[1])){
                    return (String.valueOf(number1 * number2));
                }
                if ("/".equals(splitedexpression[1])){
                    return (String.valueOf(number1 / number2));
                }
            }
            catch (NumberFormatException e2){
                return("throws Exception");
            }
        }
        catch (NumberFormatException e1) {
            try {
                int number2 = Integer.parseInt(splitedexpression[2]);
                return("throws Exception");
            }
            catch (NumberFormatException e2){
                if ((splitedexpression[0].length() < 2)||(splitedexpression[2].length() < 2)){                          //Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми. Римские числа больше 10 имеет длинну в два символа минимум
                    return("throws Exception");
                }
                char[] number1 = new char[splitedexpression[0].length()];                                               //превращаем string в массив char для удобства конверсии в арабские цифры
                char[] number2 = new char[splitedexpression[2].length()];                                               //number1 - первое число number2 - ворое число
                for (int i = 0; i < splitedexpression[0].length(); i++) {
                    number1[i] = splitedexpression[0].charAt(i);
                    if ((splitedexpression[0].charAt(i) == ',') || (splitedexpression[0].charAt(i) == '.') || ((splitedexpression[0].charAt(i) != 'I') && ((splitedexpression[0].charAt(i) != 'V') && (splitedexpression[0].charAt(i) != 'X')))){            //Калькулятор умеет работать только с целыми числами. Если входят дробные числа они не проходят parseint и поэтому нужна проверка здесь. Также проверка что число от 1 до 10 в римской системе счисления (т.е. в символах числа есть только I,V,X)
                        return("throws Exception");
                    }
                }
                for (int i = 0; i < splitedexpression[2].length(); i++) {
                    number2[i] = splitedexpression[2].charAt(i);
                    if ((splitedexpression[2].charAt(i) == ',') || (splitedexpression[2].charAt(i) == '.') || ((splitedexpression[0].charAt(i) != 'I') && ((splitedexpression[0].charAt(i) != 'V') && (splitedexpression[0].charAt(i) != 'X')))){            //Калькулятор умеет работать только с целыми числами. Если входят дробные числа они не проходят parseint и поэтому нужна проверка здесь. Также проверка что число от 1 до 10 в римской системе счисления (т.е. в символах числа есть только I,V,X)
                        return("throws Exception");
                    }
                }
                int result;                                                                                             //result - результат работы с римскими числами, необходимо проверить возможно ли его записать его в римской системе счисления, т.е. число должно быть больше 0 и меньше 4000
                if ("+".equals(splitedexpression[1])){
                    result = RomanNumber.convertertoarab(number1) + RomanNumber.convertertoarab(number2);
                    if (result > 0 && result < 4000) {
                        return (RomanNumber.convertertoroman(result));
                    }
                }
                if ("-".equals(splitedexpression[1])){
                    result = RomanNumber.convertertoarab(number1) - RomanNumber.convertertoarab(number2);
                    if (result > 0 && result < 4000) {
                        return (RomanNumber.convertertoroman(result));
                    }
                }
                if ("*".equals(splitedexpression[1])){
                    result = RomanNumber.convertertoarab(number1) * RomanNumber.convertertoarab(number2);
                    if (result > 0 && result < 4000) {
                        return (RomanNumber.convertertoroman(result));
                    }
                }
                if ("/".equals(splitedexpression[1])){
                    result = RomanNumber.convertertoarab(number1) / RomanNumber.convertertoarab(number2);
                    if (result > 0 && result < 4000) {
                        return (RomanNumber.convertertoroman(result));
                    }
                }
            }
        }
        return("throws Exception");
    }

}
