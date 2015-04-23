//3a)
/**
 * TilUtlaan.java
 * Et sted hvor man kan l&aring; og lever tilbake ting
 *
 *@author Elsie Mestl
 *@version 05.02.15
 */

interface TilUtlaan{
    /** 
     * L&aring;ner ut et objekt til en l&aring;ner. 
     * 
     * @param personene som skal l&aring;ne tingen
     * @return returnerer en ting(String)
     */
    public String laaner(String utlaaner);

    /**
     * Leverer tilbake tingen som har blitt l&aring;nt
     *
     */
    public void leveresTilbake();


}
