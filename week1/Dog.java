public class Dog{
 public int Weight;
 public static String norskDog="Hund";
 public Dog(int weight){
  Weight = weight;
 }
 public void setWeight(int weight) {
  Weight = weight;
 }
 public static void makeNoise(){
  System.out.println("bark!");
 }
 public void makeNoise2(){
  if(Weight<10){
   System.out.println("Yipyipyip!");
  }else {
   System.out.println("wooof!");
  }
 }
 public static Dog maxDog(Dog a, Dog b){
  if (a.Weight>b.Weight) {
   return a;
  }
  return b;
 }
}
