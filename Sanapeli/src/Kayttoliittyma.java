/**
 * Created by tommi on 12/03/2017.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Sanapeli sanapeli;

    Kayttoliittyma(Sanapeli sanapeli) {
        this.sanapeli = sanapeli;
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        //GridLayout layout = new GridLayout(3, 1);
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel labelKirjaimet = new JLabel("Muodosta kirjaimista mahdollisimman monta suomenkielistä sanaa.");
        JTextField textArvausKentta = new JTextField();
        JButton pelaaNappi = new JButton("Aloita peli");
        JTextArea tulostaulu=new JTextArea();
        tulostaulu.setEditable(false);

        PeliKuuntelija pKuuntelija = new PeliKuuntelija(sanapeli, labelKirjaimet, textArvausKentta, pelaaNappi, tulostaulu);
        pelaaNappi.addActionListener(pKuuntelija);
        textArvausKentta.addActionListener(pKuuntelija);

        container.add(labelKirjaimet);
        container.add(textArvausKentta);
        container.add(pelaaNappi);
    }

    public JFrame getFrame() {
        return frame;
    }
}
