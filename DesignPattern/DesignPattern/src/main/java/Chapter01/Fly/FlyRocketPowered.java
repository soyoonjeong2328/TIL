package Chapter01.Fly;

import Chapter01.Fly.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("로켓 추진으로 날라갑니다.");
    }
}
