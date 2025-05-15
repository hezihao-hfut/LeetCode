import java.util.Scanner;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        // 假设数组的最大索引不超过 100（可根据实际调整）
        int[][] a = new int[n + 1][n + 1];

        // 使用正则表达式提取每一对数字
        Pattern pattern = Pattern.compile("\\[(\\d+),(\\d+)]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            a[x][y] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            int inDegree = 0;
            int outDegree = 0;
            for (int j = 1; j <= n; ++j)
                if (a[i][j] == 1) outDegree++;
            for (int j = 1; j <= n; ++j)
                if (a[j][i] == 1) inDegree++;
            if (inDegree == n - 1 && outDegree == 0) {
                System.out.println(i);
                break;
            }
        }
        return;
    }
}