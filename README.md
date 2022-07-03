# algorithm
数据结构与算法
## 基础篇
###1. 用32位表示一个整数


对于java来说，只要是一个整数，在底层就占据了32位信息。eg:1 --> 0000 0000 0000 0000 0000 0000 0000 0001\
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

## labuladong
### 1. 数据结构的存储方式
数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）两种

**数组**由于是紧凑的连续存储，可以随机访问，通过索引快速找到对应元素，而且相对节约空间。但是也正是因为连续存储，要考虑数组的扩容问题-->扩容需要一块更大的空间，再把数据全部复制过去，时间复杂度O(N)；对数组的修改操作也是O(N)

**链表**因为元素不连续，操作相对方便，但是需要额外的内存空间存储指针

### 2. 数据结构的基本操作

#### 2.1 数组遍历框架-->迭代

```java
public class Test{
  void traverse(int[] arr){
  for (int i = 0; 0< arr.length; i++){
    //具体的操作方法
    System.out.println(arr[i])
  }
}
}
```

#### 2.1 链表遍历框架-->迭代和递归

```java
public class Test{
    // 迭代访问
    void traverse(ListNode head){
        for(ListNode p = head; p != null; p = p.next){
            System.out.println(head.val);
        }
    }
    // 递归访问
  	void traverse(ListNode head){
        traverse(head.next);
    }
  
}

class ListNode{
    int val;
    ListNode next;
}
```
二叉树是一个典型的非线形递归便利结构，代码框架如下：
```java
/*二叉树的节点*/
class TreeNode{
    int val;
    TreeNode left, right;
    
    // 递归遍历框架
    void traverse(TreeNode root){
        traverse(root.left);
        traverse(root.right);
    }
}
```
同样的，N叉树的遍历也就出来了：
```java
class TreeNode{
    int val;
    TreeNode[] children;
    // 遍历框架
    void traverse(TreeNode root){
        for (TreeNode child  : root.children) {
            traverse(child);
        }
    }
}
```
又进一步地看，图就是多个N叉树的组合，那么遍历一个图，就是对多个N叉树进行遍历。如果图出现了
环，那么也很简单，使用一个布尔类型的变量visited来标记某个节点是否被访问过即可。
更进一步，对于几乎所有的二叉树的问题，几乎都可以套用一个框架，再上述的框架上进行扩展，如下：
```java
class TreeNode{
    int val;
    TreeNode left, right;
    // 根据逻辑代码的位置不同，可以实现不同顺序的遍历
    void traverse(TreeNode node){
        // 前序遍历
        traverse(node.left);
        // 中序遍历
        traverse(node.right);
        // 后序遍历
    }
}
```
