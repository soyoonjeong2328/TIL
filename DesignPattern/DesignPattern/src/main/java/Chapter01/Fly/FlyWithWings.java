package Chapter01.Fly;

import Chapter01.Fly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("날고 있어요!!!");
    }
}
