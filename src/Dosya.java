import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dosya {
    Map<Integer, List<Kelime>> dosyalar;

    /**
     *
     * @param k
     * @param maxDosyaNo
     */
    //Constructor Metodu
    public Dosya(List<Kelime> k, int maxDosyaNo ){
        dosyalar = new HashMap<Integer, List<Kelime>>();
        for(int i = 0;i < maxDosyaNo;i++){
            dosyalar.put(i, k);
        }
    }

    public Map<Integer, List<Kelime>> getDosyalar() {
        return dosyalar;
    }

    public void setDosyalar(Map<Integer, List<Kelime>> dosyalar) {
        this.dosyalar = dosyalar;
    }


}
