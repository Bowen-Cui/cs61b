public class DogLauncher{
  public static void main(String[] args){
    Dog.makeNoise();//static method 可以用类名调用，也能被实例调用
    Dog una=new Dog(9);
    Dog louis=new Dog(20);
    una.makeNoise();//static method 也能被实例调用
    una.makeNoise2();// non-static/instance method 只能被实例调用
    louis.makeNoise2();
    //报错 Dog.makeNoise2();Non-static method 'makeNoise2()' cannot be referenced from a static context

    Dog bigger=Dog.maxDog(una,louis);
    System.out.println(bigger.Weight);

    System.out.println(Dog.norskDog);//静态变量norskDog
  }
}
