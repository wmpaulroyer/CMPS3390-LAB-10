import controllers.QuoteController;
import views.QuoteView;

public class Main {
    public static void main(String[] args) {
        QuoteView view = new QuoteView();
        new QuoteController(view);

        view.setVisible(true);
    }
}
