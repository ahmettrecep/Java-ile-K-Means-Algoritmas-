public class Kelime {
    String kelime;
    int frekans;
    double tf;
    double idf;

    public Kelime(String kelime, int frekans,double tf,double idf){
        this.kelime = kelime;
        this.frekans = frekans;
        this.tf = tf;
        this.idf = idf;
    }


    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public double getIdf() {
        return idf;
    }

    public void setIdf(double idf) {
        this.idf = idf;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public double getFrekans() {
        return frekans;
    }

    public void setFrekans(int frekans) {
        this.frekans = frekans;
    }
}
