package Chapter03;

public class Soy extends CondimentDecorator{
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 두유";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();

        // 사이즈에 따라 가격도 다르게 받기 위해
        if (beverage.getSize() == Size.TALL) {
            cost += .10;
        }else if (beverage.getSize() == Size.GRANDE){
            cost += .15;
        } else if (beverage.getSize() == Size.VENTI) {
            cost += .20;
        }
        return cost;
    }
}
