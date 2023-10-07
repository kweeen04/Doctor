import controller.Menu;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Menu menu = new Menu(view);
        menu.run();
    }
}