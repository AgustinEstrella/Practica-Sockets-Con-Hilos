import Classes.*;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        System.out.println("Welcome user, Im taking your order!");

        FacadeShop candyShop = new FacadeShop(shop);
        candyShop.openShop();
        candyShop.makePurchase();
        candyShop.closeShop();
    }
}
