package Chapter01;

import Chapter01.Fly.FlyNoWay;
import Chapter01.Quack.Quack;

public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("저는 모형 오리입니다.");
    }
}
