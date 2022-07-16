public class Mistakes{
public static void main(String[] args){

    System.out.println("Helloworld");
    int i;
    for(int i=0;i<4;i++){
        if(i==3){
            break;
        }
    }
    System.out.println(i);
    /**
     * for循环里的变量i，在for结束后会消失！！
     */
}
}
