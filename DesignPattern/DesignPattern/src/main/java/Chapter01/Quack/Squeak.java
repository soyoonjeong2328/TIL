package Chapter01.Quack;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑!");
    }
}
