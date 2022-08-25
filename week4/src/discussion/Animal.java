package discussion;
public class Animal {
    String name, noise;
    int age;

    public Animal(){}
    public Animal(String name, int age){
        this.age = age;
        this.name = name;
        noise = "Ahh";
    }
    public Animal watch(Animal a){
        System.out.println("animal watch animal");
        return new Animal();
    }

}
