package com.xufx.algorithm;

/**
 * 用32位表示一个整数
 * 打印整数的32位
 */
public class Print32Bit {
    public static void print(int num) {
        for (int i = 31; i >= 0; i--){
            // 通过与运算进行判断
            // 数字左移就是往左推相应的位置，后面用0填充
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int num = 1;
        print(num);
    }
}
