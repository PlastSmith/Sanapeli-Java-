/**
 * Created by tommi on 12/03/2017.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PeliKuuntelija implements ActionListener {

    private Sanapeli sanapeli;
    private JLabel kirjaimet;
    private JTextField arvausKentta;
    private JButton pelaaNappi;
    private JTextArea tulostaulu;


    PeliKuuntelija(Sanapeli sanapeli, JLabel kirjaimet, JTextField arvausKentta, JButton pelaaNappi, JTextArea tulostaulu) {
        this.sanapeli = sanapeli;
        this.kirjaimet = kirjaimet;
        this.arvausKentta = arvausKentta;
        this.pelaaNappi = pelaaNappi;
        this.tulostaulu = tulostaulu;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pelaaNappi) {
            this.tulostaulu.setText("");
            this.sanapeli.alustaPeli();
            this.kirjaimet.setText(this.sanapeli.getKirjaimet());
        } else if (ae.getSource() == arvausKentta) {
            this.sanapeli.tarkistaArvaus(this.arvausKentta.getText());
            this.arvausKentta.setText("");
            this.tulostaulu.setText(this.sanapeli.getTulokset());
        }

    }
}

