package Inheritance;

/**
 *  4.1 关于Static 和 Dynamic Type 的语法
 */
public class DynamicType {

    static class Thing{ int x = 5; }
    static class Animal extends Thing{
        public void speak(){
            System.out.println("I am an Animal");
        }
     }
     static class Fox extends Animal{
         @Override
         public void speak(){    //override 重写
             System.out.println("override: I am a Fox"+x+super.x);
         }
         public void speak(int y){  // overLoad 重载
             System.out.println("override: I am a Fox"+y);
         }
    }
    public static void define(Fox f) {
        System.out.println("I use Fox define");
    }
    public static void define(Animal a) {
        System.out.println("Overload: I use Animal define");
    }


    public static void main(String[] args) {

        //Fox f = (Fox) new Animal();
        /**运行出错！！！！dynamic type 必须是Fox或者Fox的子类！  */

        Animal animal;
        animal = new Fox();
        animal.speak();  //fox speak
        ( (Animal) animal).speak();//fox speak, 因为cast只能改变static type, dynamic type还是fox
        System.out.println();
        /**
         * When Java runs a method that is overriden, it searches for the appropriate method signature in it's
         * dynamic type and runs it.*/

        Fox fox2 = new Fox();
        //fox2 = animal;// 编译错误！！！两种不同的static type， 不能相互赋值；
        ((Animal)fox2).speak();
        System.out.println();
        /**虽然把 static type 改成 Animal， 但 dynamic type 还是Fox， 所以调用Fox的speak
         */

        Animal animal2 = new Animal();
        //fox2 = (Fox)animal2;  //运行错误!!!虽然骗过了编译器，让编译器以为他们是相同的type，但不能把一个Animal真变成Fox
        /**fox2和(Fox)animal2的static type都是Fox，因此可以编译，但会运行错误。
         * This would be a valid cast, as the compiler agrees that a variable of static type Animal could potentially hold a Fox。
         * 但实际并没有hold a fox, 而是hold an animal，因此运行时出错！
         */

        animal2 = animal; //animal的dynamic是fox
        fox2 = (Fox)animal2;
        fox2.speak();
        /**This would be a valid cast, as the compiler agrees that a variable of static type Animal could potentially hold a Fox。
         * 实际确实 hold a Fox, 因此成功运行，
         */

        System.out.println();

    /**
     * overloaded methods: static type
     * When Java checks to see which method to call, it checks the static type */
        Fox fox = new Fox();

        Animal animalxx = fox;
        define(fox);  //will execute define(Fox f)
        define(animalxx);//will execute define(Animal a)
        System.out.println();

        define((Animal)fox);//will execute define(Animal a),因为cast把static type改成animal,因此找到animal的define method
        define((Fox)animalxx);//will execute define(Fox f)

        fox.speak();
        fox.speak(3);
        animalxx.speak();
        //animalxx.speak(3); //编译错误！！！overload找static type---Animal---不存在该方法！

    }
}
