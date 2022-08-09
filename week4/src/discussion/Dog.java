package discussion;

public class Dog extends Animal{

    private  int size;

    public Dog(String name, int size){
        this.size = size;
        this.name = name;
    }
    public void speak(){
        System.out.println(name+": bark!");
    }


}
