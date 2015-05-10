/**
 *Genhylle.java
 *Oppbevaringsplass for en gitt mengde objekter
 *
 *@author Elsie Mestl
 *@versian  11.02.15
 */
interface GenHylle<T>{
    /**
     *Sjekker om hyllen er ledig,
     *
     *@param hyllenummeret som skal sjekkes
     *@return om den er ledig (true) eller ikke
     */
    public boolean sjekkOmLedig(int hylleNr);
    /**
     *Setter inne et nytt objekt p&aring; en bestemt plass
     *
     *@param hvilken plass
     *@param det som skal settes in
     *@return som det ble satt inn eller ikke
     */
    public boolean settInn(int hylleNr, T objekt);
    /**
     *sier hvor stor hylla er/hvor mye plass
     *
     *@return st&oslash;rrelsen p&aring; hylla
     */
    public int storrelse();
    /**
     * tar ut objekte fra en valgt hylle
     *
     *@param hvilken plass objektet skal hentes
     *@return returnerer det som var p&aring; gitt plass
     */
    public T taUt(int hylleNr);

}
