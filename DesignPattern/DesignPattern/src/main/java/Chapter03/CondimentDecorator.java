package Chapter03;

public abstract class CondimentDecorator extends Beverage{
    Beverage beverage; // 음료를 지정할때는 데코레이터에서 어떤 음료든 감쌀 수 있도록 Beverage 슈퍼 클래스 유형을 사용
    public abstract String getDescription();

    public Beverage getBeverage() {
        return beverage;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
