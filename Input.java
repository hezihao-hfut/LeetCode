import java.util.Scanner;

public class Input {
    // 创建Scanner对象用于获取键盘输入
    private static final Scanner scanner = new Scanner(System.in);

    // 输入整数
    public static int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // 输入长整数
    public static long readLong(String prompt) {
        System.out.print(prompt);
        return scanner.nextLong();
    }

    // 输入浮点数
    public static float readFloat(String prompt) {
        System.out.print(prompt);
        return scanner.nextFloat();
    }

    // 输入双精度浮点数
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    // 输入字符串
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    // 输入一行字符串
    public static String readLine(String prompt) {
        // 如果之前使用了nextInt()等方法，需要先清除缓冲区中的换行符
        scanner.nextLine(); // 可能需要的额外调用，取决于之前的输入操作
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // 输入字符
    public static char readChar(String prompt) {
        System.out.print(prompt);
        return scanner.next().charAt(0);
    }

    // 输入布尔值
    public static boolean readBoolean(String prompt) {
        System.out.print(prompt);
        return scanner.nextBoolean();
    }

    // 输入整型一维数组
    public static int[] readIntArray(String prompt, int size) {
        System.out.print(prompt);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素: ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // 输入整型二维数组
    public static int[][] readInt2DArray(String prompt, int rows, int cols) {
        System.out.print(prompt);
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("请输入第" + (i + 1) + "行第" + (j + 1) + "个元素: ");
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    // 输入字符串数组
    public static String[] readStringArray(String prompt, int size) {
        System.out.print(prompt);
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("请输入第" + (i + 1) + "个字符串: ");
            arr[i] = scanner.next();
        }
        return arr;
    }

    // 输入一行字符串并分割成数组（以空格分隔）
    public static String[] readLineToStringArray(String prompt) {
        System.out.print(prompt);
        // 清除之前可能的输入缓冲
        scanner.nextLine();
        String line = scanner.nextLine();
        return line.split("\\s+"); // 按空格分割
    }

    // 输入一行整数并分割成数组（以空格分隔）
    public static int[] readLineToIntArray(String prompt) {
        System.out.print(prompt);
        // 清除之前可能的输入缓冲
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] strArr = line.split("\\s+");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    // 关闭Scanner
    public static void closeScanner() {
        scanner.close();
    }

    // 演示各种输入方法的使用
    public static void main(String[] args) {
        // int intValue = readInt("请输入一个整数: ");
        // System.out.println("您输入的整数是: " + intValue);

        // double doubleValue = readDouble("请输入一个双精度浮点数: ");
        // System.out.println("您输入的双精度浮点数是: " + doubleValue);

        // // 注意：在使用readLine前需要清除缓冲区，否则会跳过输入
        // // 下面的调用会自动处理缓冲区问题
        // String line = readLine("请输入一行文本: ");
        // System.out.println("您输入的文本是: " + line);

        // char charValue = readChar("请输入一个字符: ");
        // System.out.println("您输入的字符是: " + charValue);

        // boolean boolValue = readBoolean("请输入一个布尔值(true/false): ");
        // System.out.println("您输入的布尔值是: " + boolValue);

        // 演示输入一维整数数组
        int[] intArray = readIntArray("接下来将输入一个整数数组\n", 3);
        System.out.print("您输入的整数数组是: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 演示一行输入多个整数
        int[] lineIntArray = readLineToIntArray("请输入多个整数，以空格分隔: ");
        System.out.print("您输入的整数数组是: ");
        for (int num : lineIntArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // // 演示输入字符串数组
        // String[] stringArray = readStringArray("接下来将输入一个字符串数组\n", 2);
        // System.out.print("您输入的字符串数组是: ");
        // for (String str : stringArray) {
        // System.out.print(str + " ");
        // }
        // System.out.println();

        // 演示输入二维数组
        int[][] int2DArray = readInt2DArray("接下来将输入一个2x2的二维数组\n", 2, 2);
        System.out.println("您输入的二维数组是:");
        for (int[] i : int2DArray) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // // 演示输入一行字符串并分割
        // String[] splitStrings = readLineToStringArray("请输入多个单词，以空格分隔: ");
        // System.out.print("您输入的单词是: ");
        // for (String str : splitStrings) {
        // System.out.print(str + " ");
        // }
        // System.out.println();

        // 使用完毕后关闭Scanner
        closeScanner();
    }
}
