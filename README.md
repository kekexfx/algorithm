# algorithm
数据结构与算法
## 基础篇
###1. 用32位表示一个整数
&emsp;&emsp;对于java来说，只要是一个整数，在底层就占据了32位信息。eg:1 --> 0000 0000 0000 0000 0000 0000 0000 0001\
代码:
```java
public class Print32Bit {
    public static void print(int num) {
        for (int i = 31; i >= 0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int num = 1;
        print(num);
    }
}
```
* java整数是有符号的，可以表示的最大范围是(0～2^32 - 1);无符号的只能表示(-2^31 ~ 2^31 - 1)

