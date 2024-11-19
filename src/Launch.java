import controllers.QuoteController;
import views.QuoteView;

import java.io.IOException;

public class Launch {
    public static void main(String[] args) throws IOException {
        QuoteView view = new QuoteView();
        new QuoteController(view);
        
        view.setVisible(true);
    }
}
