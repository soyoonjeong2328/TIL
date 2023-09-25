package Chapter03;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso(); // 아무것도 넣지 않은 에스프레소를 주문
        System.out.println(beverage.getDescription() + " $" + beverage.cost());


        Beverage beverage2 = new DarkRoast(); // DarkRoast 객체 생성
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
