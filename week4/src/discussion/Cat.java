package discussion;

public class Cat extends Animal {

    public Cat(){}

    public Cat(String name, int age){
        super(name, age);
        this.noise = "Meow!";
    }


    public static void main(String[] args) {
        Cat x = new Cat("Kitty", 5);
    }
}
