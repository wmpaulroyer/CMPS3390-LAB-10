package controllers;

import models.Quote;
import org.json.JSONObject;
import views.QuoteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class QuoteController {
    private final QuoteView view;

    public QuoteController(QuoteView view){
        this.view = view;

        view.attachBookListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateQuote("book");
            }
        });

        view.attachMovieListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateQuote("movie");
            }
        });

        view.attachGameListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateQuote("game");
            }
        });
    }

    private void updateQuote(String category){
        URL url = null;
        Scanner scanner = null;
        StringBuilder jsonString = new StringBuilder();

        // MAKE API REQUEST AND BUILD RESPONSE STRING
        try {
            url = new URI("https://cs.csub.edu/~paul/3390/quotesAPI/?category=" + category).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("Invalid Server Request");
            }

            scanner = new Scanner(conn.getInputStream());
            while(scanner.hasNext()){
                jsonString.append(scanner.nextLine());
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            view.displayError("Unable to get quote!");
        }

        // PARSE JSON OBJECT FROM RESPONSE
        JSONObject obj = new JSONObject(jsonString.toString());

        // CREATE QUOTE FROM JSON AND UPDATE VIEW
        Quote quote =  new Quote(obj.getString("quote"), obj.getString("author"));
        view.setQuote(quote);
    }
}
