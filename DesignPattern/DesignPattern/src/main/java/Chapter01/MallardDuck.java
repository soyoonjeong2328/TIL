package Chapter01;

import Chapter01.Fly.FlyWithWings;
import Chapter01.Quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack(); // 꽥
        flyBehavior = new FlyWithWings(); // 날고 있어요
    }

    @Override
    public void display() {
        System.out.println("저는 물오리 입니다.");
    }
}
