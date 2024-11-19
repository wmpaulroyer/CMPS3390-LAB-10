package views;

import models.Quote;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class QuoteView extends JFrame {
    private JPanel panelMain;
    private JPanel controls;
    private JButton buttonBook;
    private JButton buttonMovie;
    private JButton buttonGame;
    private JLabel labelAuthor;
    private JTextArea textAreaQuote;

    public QuoteView() throws IOException {
        setContentPane(panelMain);
        setTitle("Quote Generator");
        setSize(500, 400);

        URL iconURL = getClass().getClassLoader().getResource("images/quoteGenerator.png");
        assert iconURL != null;
        Image iconImage = ImageIO.read(iconURL);
        setIconImage(iconImage);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setQuote(Quote quote){
        textAreaQuote.setText(quote.getQuote());
        labelAuthor.setText(quote.getAuthor());
    }

    public void displayError(String error){
        JOptionPane.showMessageDialog(this, error);
    }

    public void attachBookListener(ActionListener listener){
        buttonBook.addActionListener(listener);
    }

    public void attachMovieListener(ActionListener listener){
        buttonMovie.addActionListener(listener);
    }

    public void attachGameListener(ActionListener listener){
        buttonGame.addActionListener(listener);
    }
}
