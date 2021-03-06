/*
 * Τμήμα ΗΛΕ 43
 * @author ΒΑΣΙΛΗΣ ΤΣΑΠΑΡΙΚΟΣ - 114307
 * @author ΑΙΚΑΤΕΡΙΝΗ ΚΟΛΕΒΕΝΤΗ - 126971
 * @author ΑΡΙΣΤΕΙΔΗΣ ΦΑΣΟΥΛΑΣ - 100318
 */
package controller;

import java.util.List;
import model.CountryData;


public class ControllerCountryData extends Controller{

    public ControllerCountryData()
    {
        super();
    }
    /**
     * 
     * @param c a list of CountryData to be added to the database
     */
    public void addCountryData(List<CountryData>  c){
        for(CountryData cc : c){
            em.getTransaction().begin();
            em.persist(cc);
            em.getTransaction().commit();
        }
    }
    
    /**
     * Method that erases all Data in the Table
     */
    public void deleteData(){
        clearTbl("CountryData.deleteAll");
    }
    
    @Override
        protected void clearTable() {
        clearTbl("City.deleteAll");
    }
    
}
