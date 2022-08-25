package discussion;

public class Cat extends Animal {

    public Cat(){}

    public Cat(String name, int age){
        super(name, age);
        this.noise = "Meow!";
    }
    //@Override
    public Cat watch(Dog dog){
        System.out.println("cat watch dog");
        return new Cat();
    }
    @Override
    public Cat watch(Animal animal){
        System.out.println("cat watch animal");
        return new Cat();
    }

    public void speak() {
        System.out.println("cat speak");
    }


    public static void main(String[] args) {

        Cat x = new Cat("Kitty", 5);
        Dog d = new Dog();
        Animal a = new Cat();
        a.watch(d);
    }
}
