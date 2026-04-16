
package gd5_d_13000;

public class TwoPair <K, V> {
    private K valueK;
    private V valueV;

    public TwoPair(K valueK, V valueV) {
        this.valueK = valueK;
        this.valueV = valueV;
    }

    public K getValueK() {
        return valueK;
    }

    public V getValueV() {
        return valueV;
    }

    public void setValueK(K valueK) {
        this.valueK = valueK;
    }

    public void setValueV(V valueV) {
        this.valueV = valueV;
    }
}