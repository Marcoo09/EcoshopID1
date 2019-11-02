/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilites;

/**
 *
 * @author Agustin Hernandorena
 * @param <T>
 * @param <R>
 */
public class Pair <T,R> implements Comparable <Pair>  {
    private T leftDate;
    private R rightDate;

    public T getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(T leftDate) {
        this.leftDate = leftDate;
    }

    public R getRightDate() {
        return rightDate;
    }

    public void setRightDate(R rightDate) {
        this.rightDate = rightDate;
    }
    
    @Override
    public int compareTo(Pair o){
        return (int)this.leftDate-(int)o.leftDate;
    }
    
}
