package Chapter01;

import Chapter01.Fly.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performQuack();
        duck.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
