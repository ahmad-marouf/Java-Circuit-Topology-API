package components;

public class NmosMeasure implements Measure {

    private float def;
    private float min;
    private  float max;

    public NmosMeasure(float def, float min, float max) {
        this.def = def;
        this.min = min;
        this.max = max;
    }

    public float getDef() { return def; }

    public float getMin() { return min; }

    public float getMax() { return max; }

    @Override
    public String toString() {
        return  "default=" + def + ", min=" + min + ", max=" + max;
    }
}
