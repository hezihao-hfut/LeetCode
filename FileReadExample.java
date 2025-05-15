import java.io.*;
import java.nio.charset.StandardCharsets; // 用于指定字符编码

public class FileReadExample {

    private static final String FILE_NAME = "example.txt";
    private static final String FILE_CONTENT = "Hello, Java I/O Streams!\nThis is a test file.\n第三行包含中文。";

    // 辅助方法：创建用于演示的文件
    private static void createFileForDemo() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            fos.write(FILE_CONTENT.getBytes(StandardCharsets.UTF_8)); // 使用UTF-8编码写入字节
            System.out.println("Created demo file: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error creating demo file: " + e.getMessage());
        }
    }

    // 1. 使用字节流读取文件
    // 读取原始字节数据
    public static void readFileByteByByte() {
        System.out.println("\n--- Reading file byte by byte (using FileInputStream) ---");
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            int byteData;
            // read() 方法读取一个字节（返回 int，-1 表示文件末尾）
            while ((byteData = fis.read()) != -1) {
                // 可以将字节数据转换为字符打印，但需要考虑编码
                //System.out.print((char) byteData); // 简单转换，可能导致中文乱码
                System.out.print(byteData + " "); // 直接打印字节的整数值
            }
            System.out.println("\nFinished reading byte by byte.");
        } catch (IOException e) {
            System.err.println("Error reading file byte by byte: " + e.getMessage());
        }
    }

     // 1b. 使用字节流结合缓冲读取文件
    public static void readFileBufferedByte() {
        System.out.println("\n--- Reading file with buffered bytes (using BufferedInputStream) ---");
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             // 将 FileInputStream 包装在 BufferedInputStream 中
            BufferedInputStream bis = new BufferedInputStream(fis)) {

            byte[] buffer = new byte[1024]; // 缓冲区
            int bytesRead;
            // read(byte[] buffer) 方法读取到缓冲区，返回读取到的字节数，-1 表示文件末尾
            while ((bytesRead = bis.read(buffer)) != -1) {
                 // 将缓冲区中的字节转换为字符串（需要指定编码）
                 String chunk = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                 System.out.print(chunk);
            }
            System.out.println("\nFinished reading buffered bytes.");

        } catch (IOException e) {
            System.err.println("Error reading file with buffered bytes: " + e.getMessage());
        }
    }


    // 2. 使用字符流读取文件
    // 专门用于处理文本文件
    public static void readFileCharByChar() {
        System.out.println("\n--- Reading file character by character (using FileReader) ---");
        try (FileReader fr = new FileReader(FILE_NAME, StandardCharsets.UTF_8)) { // 指定编码
            int charData;
            // read() 方法读取一个字符（返回 int，-1 表示文件末尾）
            while ((charData = fr.read()) != -1) {
                System.out.print((char) charData); // 直接转换为 char 打印
            }
            System.out.println("\nFinished reading character by character.");
        } catch (IOException e) {
            System.err.println("Error reading file character by character: " + e.getMessage());
        }
    }


    // 3. 使用流的链式连接读取文件 (推荐方式 for text files)
    // 结合字节流、桥接流和缓冲字符流
    public static void readFileLineByLineBuffered() {
        System.out.println("\n--- Reading file line by line (using chained streams: FileInputStream -> InputStreamReader -> BufferedReader) ---");
        // 使用 try-with-resources 确保所有流都被关闭
        try (FileInputStream fis = new FileInputStream(FILE_NAME); // 原始字节流
             // 将字节流转换为字符流，指定编码 (重要!)
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             // 在字符流之上增加缓冲，并提供 readLine() 方法
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            // readLine() 方法读取一行文本，返回 null 表示文件末尾
            while ((line = br.readLine()) != null) {
                System.out.println("Line: " + line); // 打印读取到的一整行
            }
            System.out.println("Finished reading line by line.");

        } catch (IOException e) {
            System.err.println("Error reading file line by line: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        createFileForDemo(); // 先创建示例文件

        readFileByteByByte();       // 演示字节流按字节读取
        readFileBufferedByte();     // 演示字节流按块读取 (带缓冲)
        readFileCharByChar();       // 演示字符流按字符读取
        readFileLineByLineBuffered(); // 演示链式连接流按行读取 (文本文件最常用)

        // 注意：try-with-resources 会自动关闭流，所以这里不需要手动 close()
    }
}
