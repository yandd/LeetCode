package knowledge.baseKnowledge.javaInherit;

public class ProtectInhiritSon extends ProtectInhiritParent {
    private JavaWife javaWife;

    public String toString() {
        setName(" Janus");
        return super.toString();
    }

    public static void main(String[] args) {
        //main method
        ProtectInhiritSon son = new ProtectInhiritSon();
        System.out.println(son.toString());
    }
}
