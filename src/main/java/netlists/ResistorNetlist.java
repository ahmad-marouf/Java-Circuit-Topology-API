package netlists;


public class ResistorNetlist implements Netlist {

    private String t1;
    private String t2;

    public ResistorNetlist(String t1, String t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "t1='" + t1 + '\'' + ", t2='" + t2 + '\'';
    }
}
