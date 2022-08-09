public class ArgsSum {
    /**
     * Exercise 1.2.3: Summing Command Line Arguments
     * Try to write a program that sums up the command line arguments,assuming they are numbers.
     * @param args
     * args[i]是从控制台接收的string参数 的数组
     * 程序在cmd中运行
     * C:\Users\cbw81\java\cs61b\week1>javac ArgsSum.java
     * C:\Users\cbw81\java\cs61b\week1>java ArgsSum 3 4 12 53 5
     * 77
     */
    public static void main(String[] args) {
        int sum=0;
        for(int i=0; i<args.length; i++){
            sum+=Integer.parseInt(args[i]);//把字符串args[i]转换成int
        }
        System.out.println(sum);
    }
}
