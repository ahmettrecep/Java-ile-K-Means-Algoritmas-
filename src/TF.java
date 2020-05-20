import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TF {
    static double tf(List<Kelime> kelimeler, String tekKelime) {
        double n = 0;
        for (Kelime s: kelimeler)
            if (s.kelime.equalsIgnoreCase(tekKelime))
                n++;
        return n / kelimeler.size();
    }
    static double idf(int dosyaSayisi, List<Kelime> k, String tekKelime) {
        double n = 0;
        for (int i=0;i<dosyaSayisi;i++) {
            for (int j=0;j<k.size();j++)
                if (k.get(j).kelime.equalsIgnoreCase(tekKelime)) {
                    n++;
                    break;
                }
        }
        return Math.log(k.size() / n);
    }
}