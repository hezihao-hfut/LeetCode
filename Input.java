import java.util.Scanner;
import java.util.Arrays;
public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数 (例如: 5 10):");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("读取到的 n: " + n);
        System.out.println("读取到的 m: " + m);

        System.out.println("输入长度为n的数组:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        System.out.println(Arrays.toString(arr));

        scanner.nextLine(); // 消耗scanner.nextInt()剩下的换行符

        System.out.println("输入未知长度的数组:");
        String[] strs = scanner.nextLine().split(" ");
        System.out.println(Arrays.toString(strs));

        System.out.println("输入字符串:");
        String str = scanner.nextLine();
        System.out.println("输出字符串：" + str);

        scanner.close();
    }
}
