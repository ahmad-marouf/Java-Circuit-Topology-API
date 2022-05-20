package components;

public class ResistorMeasure implements Measure {

    private int def;
    private int min;
    private  int max;

    public ResistorMeasure(int def, int min, int max) {
        this.def = def;
        this.min = min;
        this.max = max;
    }

    public int getDef() { return def; }

    public int getMin() { return min; }

    public int getMax() { return max; }

    @Override
    public String toString() {
        return  "default=" + def + ", min=" + min + ", max=" + max;
    }
}
