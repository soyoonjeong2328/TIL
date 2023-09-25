package Chapter03;

public class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage) { // 감싸고자 하는 음료를 저장하는 인스턴스 변수
        this.beverage = beverage; // 인스턴스 변수를 감싸고자 하는 객체로 설정하는 생성자
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }

    @Override
    public double cost() {
        return beverage.cost() + .20; // 기존 음료 가격에 모카를 추가한 가격
    }
}
