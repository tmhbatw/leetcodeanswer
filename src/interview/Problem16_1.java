package interview;

public class Problem16_1 {
    /*Description
    * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
    * */

    public int[] swapNumbers(int[] numbers) {
        numbers[0]=numbers[0]+numbers[1];
        numbers[1]=numbers[0]-numbers[1];
        numbers[0]=numbers[0]-numbers[1];
        return numbers;
    }
}
