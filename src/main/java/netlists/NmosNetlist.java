package netlists;


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
    public String toString() {
        return "drain='" + drain + '\'' + ", gate='" + gate + '\'' + ", source='" + source + '\'';
    }
}
