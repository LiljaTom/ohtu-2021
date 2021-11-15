
package ohtu.verkkokauppa;


public interface BankInterface {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
