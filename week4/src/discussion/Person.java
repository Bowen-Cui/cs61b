package discussion;

public interface Person {
    void sleep();

    public class Man implements Person {
        @Override
        public void sleep() {
            System.out.println("man sleep");
        }
    }
    public class Woman implements Person {
        public void speak() {
            System.out.println("woman speak");
        }
        @Override
        public void sleep() {
            System.out.println("woman sleep");
        }
    }

    public class Todo {
        public static void todo(Person a){
            a.sleep();
        }
    }

    public static void main(String[] args) {
        Man man = new Man();
        Person woman = new Woman();
        Todo.todo(man);
        Todo.todo(woman);

    }

}
