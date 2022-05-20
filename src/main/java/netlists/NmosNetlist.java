package netlists;


import org.json.simple.JSONObject;

public class NmosNetlist implements Netlist {

    private String drain;
    private String gate;
    private String source;

    public NmosNetlist(String drain, String gate, String source) {
        this.drain = drain;
        this.gate = gate;
        this.source = source;
    }

    @Override
    public JSONObject formatJSON() {
        JSONObject netlistObj = new JSONObject();
        netlistObj.put("drain", this.drain);
        netlistObj.put("gate", this.gate);
        netlistObj.put("source", this.source);
        return netlistObj;
    }

    @Override
    public String toString() {
        return "drain='" + drain + '\'' + ", gate='" + gate + '\'' + ", source='" + source + '\'';
    }


}
