package discussion;

public class Test {
    public static void main(String[] args) {
        Cat jimmy = new Cat("Jimmy",5);
        //Dog limmy = (Dog) jimmy;  // 编译错误：cat不能直接cast给dog
       // Dog mangotan = (Dog)(Animal) jimmy;
        //mangotan.speak(); //运行时错误：class discussion.Cat cannot be cast to class discussion.Dog

        Animal a = new Cat();
        Animal x = new Animal();
        Dog y = new Dog();
        a.watch(x);//cat watch animal--override
        a.watch(y);//!!!还是cat watch animal！！！向上转型无法调用子类的独有方法--cat.watch（Dog）,编译时已经锁定watch(Animal)

        Cat c = new Cat();
        c.watch(y);//cat watch dog


    }

}
