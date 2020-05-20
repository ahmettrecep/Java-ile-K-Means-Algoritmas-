import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DosyaIslemleri> d = new LinkedList<DosyaIslemleri>();
        d.add(new DosyaIslemleri("C:\\Users\\casper\\Desktop\\makine_ogrenmesi\\" + "1.txt"));
        d.add(new DosyaIslemleri("C:\\Users\\casper\\Desktop\\makine_ogrenmesi\\" + "2.txt"));
        d.add(new DosyaIslemleri("C:\\Users\\casper\\Desktop\\makine_ogrenmesi\\" + "3.txt"));
        /*for(int i=1;i<4;i++){
            d.get(i).idf();
        }*/

        /*DosyaIslemleri[] dosyalar = new DosyaIslemleri[14];
        for(int i = 1;i < 15; i++){
            System.out.println(i);
            dosyalar[i] = new DosyaIslemleri("C:\\Users\\casper\\Desktop\\makine_ogrenmesi\\" + i + ".txt");

        }*/
    }
}
