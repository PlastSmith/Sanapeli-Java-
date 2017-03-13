/**
 * Created by tommi on 10/03/2017.
 */

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Sanapeli sanapeli = new Sanapeli();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(sanapeli);
        SwingUtilities.invokeLater(kayttoliittyma);

        //Sanapeli sanapeli = new Sanapeli();
        //sanapeli.pelataanPelia();
    }
}