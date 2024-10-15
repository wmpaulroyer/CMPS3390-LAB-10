package views;

import models.Quote;

import javax.swing.*;
import java.awt.event.ActionListener;

public class QuoteView extends JFrame {
    private JPanel panelMain;
    private JPanel controls;
    private JButton buttonBook;
    private JButton buttonMovie;
    private JButton buttonGame;
    private JLabel labelAuthor;
    private JTextArea textAreaQuote;

    public QuoteView(){
        setContentPane(panelMain);
        setTitle("Quote Generator");
        setSize(500, 400);

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
