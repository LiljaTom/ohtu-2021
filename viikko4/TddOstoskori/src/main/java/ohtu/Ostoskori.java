package ohtu;

import java.util.List;
import java.util.ArrayList;

public class Ostoskori {

    private List<Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new ArrayList<>();
    }
 
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2
        int tavaroita = 0;
        for(int i = 0; i < ostokset.size(); i++) {
            tavaroita += ostokset.get(i).lukumaara();
        }   

        return tavaroita;
    }
 
    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        int hinta = 0;

        for(int i = 0; i < ostokset.size(); i++) {
            hinta += ostokset.get(i).hinta();
        }   
        return hinta;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        boolean found = false;
        for(int i = 0; i < ostokset.size(); i++) {
            if(ostokset.get(i).tuotteenNimi().equals(lisattava.getNimi())) {
                ostokset.get(i).muutaLukumaaraa(1);
                found = true;
            }
        }

        if(!found) {
            Ostos ostos = new Ostos(lisattava);
            ostokset.add(ostos);
        }
    }
 
    public void poista(Tuote poistettava) {
        for(int i = 0; i < ostokset.size(); i++) {
            if(ostokset.get(i).tuotteenNimi().equals(poistettava.getNimi())) {
                ostokset.get(i).muutaLukumaaraa(-1);

                if(ostokset.get(i).lukumaara() == 0) {
                    ostokset.remove(i);
                }
                break;
            }
        }

    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return ostokset;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
        ostokset = new ArrayList<>();
    }
}
