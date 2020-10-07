import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        // 小明很喜欢数学,有一天他在做数学作业时,要求计算出 9 ~ 16 的和,他马上就写出了正确答案是 100。
        // 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为 100(至少包括两个数)。
        // 没多久,他就得到另一组连续正数和为 100 的序列:18, 19, 20, 21, 22。
        // 现在把问题交给你,你能不能也很快的找出所有和为 S 的连续正数序列

        //输出描述:
        //输出所有和为 S 的连续正数序列。
        // 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        System.out.println(FindContinuousSequence(sum));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        int addSum = 0;
        int cur = 0;
        for (cur = 1; cur <= sum; cur++) {
            addSum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = cur; i <= sum; i++) {
                if (addSum > sum) {
                    break;
                } else if (addSum == sum) {
                    listAll.add(list);
                    break;
                } else if (addSum < sum) {
                    addSum += i;
                    list.add(i);
                }
            }
        }
        return listAll;
    }

    public static void main2(String[] args) {
        // 输入一个递增排序的数组和一个数字 S，在数组中查找两个数
        // 使得他们的和正好是 S，如果有多对数字的和等于 S，输出两个数的乘积最小的。

        // 输出描述:
        // 对应每个测试案例，输出两个数，小的先输出。

        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.print(FindNumbersWithSum(array, sum));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int len = array.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        int mutl = array[len - 1] * array[len - 2];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (sum == array[i] + array[j]) {
                    if (array[i] * array[j] < mutl) {
                        mutl = array[i] * array[j];
                        list.clear();
                        list.add(array[i]);
                        list.add(array[j]);
                        break;
                    }
                } else if (array[i] + array[j] > sum) {
                    break;
                }
            }
        }
        return list;
    }

    public static void main3(String[] args) {
        // 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
        // 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
        // 例如，字符序列 S=”abcXYZdef”,要求输出循环左移3位后的结果，即 “XYZdefabc”。
    }

    public String LeftRotateString1(String str, int n) {
        List<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = n; i < chars.length; i++) {
            list.add(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            list.add(chars[i]);
        }
        String strs = String.valueOf(list);
        return strs;
        // 遗留问题：
        // 预期输出：XYZdefabc
        // 实际输出：[X, Y, Z, d, e, f, a, b, c]
    }
    public String LeftRotateString(String str, int n) {
        // 最优解
        if (str.length() == 0 || str == null) {
            return str;
        }
        return str.substring(n, str.length()) + str.substring(0, n);
        // 开区间
    }

    public static void main(String[] args) {
        // 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
        // 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
        // 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
        // Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
    }
    public String ReverseSentence(String str) {
        String[] strArr = str.split(" ");
        if (strArr.length == 0 || strArr.length == 1 || str == null) {
            return str;
        }
        if (strArr.length == 2) {
            return strArr[1] + " " + strArr[0];
        }
        String s = strArr[strArr.length - 1] + " ";
        for (int i = strArr.length - 2; i > 0; i--) {
            s += strArr[i] + " ";
        }
        s += strArr[0];
        return s;
    }
}