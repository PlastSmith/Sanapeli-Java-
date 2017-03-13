/**
 * Created by tommi on 10/03/2017.
 * KAYTTOLIITTYMA
 * SANOJEN TARKSITAMINEN
 * AJASTIN
 * KIRJAINTEN ARPOMINEN
 * SANAN LISÄÄMINEN
 *
 * sed -ne 's,.*<s>\(.*\)</s>.*,\1,p' kotus-sanalista_v1.xml > kotus_sanat.txt
 *
 */

import java.io.File;
import java.util.*;

class Sanapeli {

    private Boolean ohjelmaKaynnissa;
    private Boolean peliKaynnissa;
    private ArrayList<String> sanakirja;
    private ArrayList<String> oikeinArvatutSanat;
    private ArrayList<String> arvatutSanat;
    private String kirjaimet;
    private String aakkoset;


    Sanapeli() {
        this.ohjelmaKaynnissa = false;
        this.peliKaynnissa = false;
        this.sanakirja = new ArrayList<>();
        this.oikeinArvatutSanat = new ArrayList<>();
        this.arvatutSanat = new ArrayList<>();
        this.kirjaimet = "";
        this.aakkoset = "abcdefghijklmnopqrstuvxyzåäö";

        alustetaanSanakirja();
    }

    void alustaPeli() {
        luodaanKirjaimet();
        this.arvatutSanat.clear();
        this.oikeinArvatutSanat.clear();
    }

    private void luodaanKirjaimet() {
        this.kirjaimet = "";
        Random random = new Random();
        Date date = new Date();
        random.setSeed(date.getTime());

        for (int i=0; i < 7; i++ ) {
            this.kirjaimet += this.aakkoset.charAt(random.nextInt(28));
            System.out.println(this.kirjaimet);
        }
    }

    void tarkistaArvaus(String arvaus) {
        if (vainPelinKirjaimia(arvaus) && loytyyListasta(arvaus)) {
            this.oikeinArvatutSanat.add(arvaus);
        }
    }

    private Boolean vainPelinKirjaimia(String arvaus) {
        StringBuilder cArvaus = new StringBuilder(arvaus);
        char cKirjain = '0';
        String sKirjain = " ";

        //System.out.println(cArvaus.toString());
        //System.out.println(cArvaus.length());
        // Tarkistetaan että vain kirjaimia
        // toteutus tahan

        // Tarkistetaan ettei arvatus sanassa ole vääriä kirjaimia.
        // toteutus tahan

        // Tarkistetaan että kirjaimia on käytetty oikea maara.

        for(int i=0; i < this.kirjaimet.length(); i++) {
            for(int j=0; j < arvaus.length(); j++) {
                if (arvaus.charAt(j) == this.kirjaimet.charAt(i)) {

                    cKirjain = arvaus.charAt(j);
                    sKirjain ="";
                    sKirjain += cKirjain;
                    System.out.println("skirjian: "+sKirjain);

                    if (cArvaus.length() > 0) {
                        int index = cArvaus.indexOf(sKirjain);
                        System.out.println("indeksi"+index);
                        System.out.println("pituus: " + cArvaus.length());
                        cArvaus.deleteCharAt(index);
                        break;
                    }
                    //cArvaus.deleteCharAt(j-poistettuja);
                    //edellisenIndex = j;
                }
            }
        }

        return cArvaus.length() == 0;
    }


    private Boolean loytyyListasta(String arvaus) {
        for(String sana: this.sanakirja) {
            if (sana.equals(arvaus) && !this.oikeinArvatutSanat.contains(arvaus)) {
                return true;
            }
        }
        return false;
    }





    private void tulostaArvatut() {
        if (!this.oikeinArvatutSanat.isEmpty()) {
            System.out.print("Oikein arvatut sanat: \n");
            for (String sana : this.oikeinArvatutSanat) {
                System.out.print(sana + " ");
            }
            System.out.println("\n");
        }
    }

    private void alustetaanSanakirja() {

        File tiedosto = new File("E:\\Users\\tommi.DESKTOP-CEFR2CM\\Documents\\Ohjelmointi\\Sanapeli\\src\\Files\\Sanakirja.txt");

        Scanner tLukija= null;
        try {
            tLukija = new Scanner(tiedosto, "UTF-8");
        } catch ( Exception e ) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return;
        }
        while (tLukija.hasNextLine()) {
            String rivi = tLukija.nextLine();
            if (!rivi.isEmpty()) {
                this.sanakirja.add(rivi);
            }
        }

        tLukija.close();
    }

    private void tulostaArvausProsentti() {
        if (this.arvatutSanat.size() + this.oikeinArvatutSanat.size() > 0) {
            double prosentti = this.oikeinArvatutSanat.size() * 100.0 / (this.arvatutSanat.size() + this.oikeinArvatutSanat.size());
            System.out.println("Arvaus prosentti: " + prosentti + " %");
        }
    }

    private void tulostaSanakirja() {
        for(String sana : this.sanakirja) {
            System.out.println(sana);
        }
    }


    String getKirjaimet() {
        return this.kirjaimet.toUpperCase();
    }

    String getTulokset() {
        return this.kirjaimet.toUpperCase();
    }
}
