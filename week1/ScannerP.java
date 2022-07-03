import java.util.Scanner;

public class ScannerP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine(); //!读取nextInt的默认换行符"".nextLine:scans from the current position until it finds a line separator delimiter
        String s = sc.nextLine();
        System.out.println(a);
        System.out.println(s);
    }






}
