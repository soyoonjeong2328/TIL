package Chapter01.Fly;

import Chapter01.Fly.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("저는 못날아요!!ㅜㅠㅜ");
    }
}
