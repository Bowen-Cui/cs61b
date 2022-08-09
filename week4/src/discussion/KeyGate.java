package discussion;

public class KeyGate {
    public static class Fingerprint {}
    public static class Key {  }
    public static class SkeletonKey extends Key {  }
    public static class StandardBox {
        public void unlock(Key k) {System.out.println("StandardBox Key");} } // UK
    public static class BioBox extends StandardBox {
        public void unlock(SkeletonKey sk) {System.out.println("BioBox sk");} // USK
        public void unlock(Fingerprint f) {System.out.println("BioBox f");  } // UF
    }
    public static void doStuff(Key k, SkeletonKey sk, Fingerprint f) {
        StandardBox sb = new StandardBox();
        StandardBox sbbb = new BioBox();
        BioBox bb = new BioBox();

        sbbb.unlock(k);
        bb.unlock(k);
        sb.unlock(sk);
        sbbb.unlock(sk);//overload
        bb.unlock(sk);
        // sbbb.unlock(f);//编译器检查看static type
        bb = (BioBox) sbbb;
        ((StandardBox) bb).unlock(sk);//重载 看static type=》 StandardBox
        ((StandardBox) sbbb).unlock(sk);
        ((BioBox) sb).unlock(sk);//！！！运行时错误！！！

    }

    public static void main(String[] args) {

        Key k = new Key();
        SkeletonKey sk = new SkeletonKey();
        Fingerprint f = new Fingerprint();

        doStuff(k,sk,f);
    }
}
