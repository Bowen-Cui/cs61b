public class Triangle{
  public static void drawTriangle(int N){
    for(int i=0;i<N;i++){
      for(int q=0;q<=i;q++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    drawTriangle(10);

  }

}
