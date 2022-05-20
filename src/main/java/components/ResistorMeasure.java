package components;

import org.json.simple.JSONObject;

public class ResistorMeasure implements Measure {

    private int def;
    private int min;
    private  int max;

    public ResistorMeasure(int def, int min, int max) {
        this.def = def;
        this.min = min;
        this.max = max;
    }

    @Override
    public JSONObject formatJSON() {
        JSONObject measureObj = new JSONObject();
        measureObj.put("default", this.def);
        measureObj.put("min", this.min);
        measureObj.put("max", this.max);
        return measureObj;
    }

    public int getDef() { return def; }

    public int getMin() { return min; }

    public int getMax() { return max; }

    @Override
    public String toString() {
        return  "default=" + def + ", min=" + min + ", max=" + max;
    }
}
