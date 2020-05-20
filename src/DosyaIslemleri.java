import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DosyaIslemleri {
    String URL;
    public DosyaIslemleri(String URL){
        this.URL = URL;
        dosyaAc(URL);
        listeyiYazdir();
    }

    static List<Kelime> k = new LinkedList<Kelime>();
    private static void dosyaAc(String URL){
        File dosya = new File(URL);
        Scanner oku = null;
        try {
            oku = new Scanner(dosya);
        } catch (FileNotFoundException e) {
            System.out.println("'dosyaAc' Metodunda Dosya Tanımlarken Hata!");
        }
        kelimeleriBul(oku);
        veriyiTemizle();
    }
    private static void kelimeleriBul(Scanner oku){
        while(oku.hasNext()){
            String kelime = "";
            kelime += oku.next();
            kelimeAra(kelime);
        }
        //for(int i=0;i<k.size();i++){
            tf();
                /*double idfSonuc = idf(1,k,k.get(j).kelime);
                k.get(j).setIdf(idfSonuc);*/
        //}
        for (int i=0;i<k.size();i++){
            System.out.println(k.get(i).getKelime() + " Kelimesinin TF ' si : \t" + k.get(i).getTf());
        }
        for(int  i=0;i<k.size();i++){
            System.out.println(k.get(i).getKelime() + " Kelimesinin IDF ' si : \t" + k.get(i).getIdf());
        }
    }

    /**

     * @return
     */
    static void tf() {
        double n = 0;
        for (int i = 0; i < k.size(); i++) {
            double sonuc = k.get(i).getFrekans() / k.size();
            k.get(i).setTf(sonuc);
        }
    }

    public static void idf(List<DosyaIslemleri> d) {
        double n = 0;
        int iterasyon = 0;
        while(iterasyon<d.size()){
            n = 0;
            DosyaIslemleri tmp = d.get(iterasyon);
            d.remove(iterasyon);
            for(int i=0;i<tmp.k.size();i++){
                for(int j=0;j<d.get(iterasyon).k.size();j++){
                    if(tmp.k.get(i).getKelime().equalsIgnoreCase(d.get(iterasyon).k.get(j).getKelime())){
                        n++;
                    }
                }
                tmp.k.get(i).setIdf(n);
                d.add(i,tmp);
            }
            iterasyon++;
        }

            /*for (int j=0;j<k.size();j++) {
                Kelime temp = new Kelime(k.get(j).getKelime(), k.get(j).getFrekans(), k.get(j).getTf(), k.get(j).getIdf());
                k.remove(j);
                for(int t=0;t<k.size()-1;t++){
                    if(k.get(t).getKelime().equalsIgnoreCase(temp.getKelime())){
                        n++;
                        System.out.println("N değeri : " + n);
                        break;
                    }
                }
                double idf = Math.log(d.length / n);
                temp.setIdf(n);
                k.add(j, temp);
            }*/

    }



    private static void kelimeAra(String kelime){
        if(!k.isEmpty()) {
            int i = 0;
            Kelime mevcut = k.get(i);
            boolean bulundu = false;
            while (i < k.size()) {
                mevcut = k.get(i);
                if (mevcut.kelime.equalsIgnoreCase(kelime)) {
                    mevcut.frekans += 1;
                    bulundu = true;
                    break;
                } else {
                    bulundu = false;
                }
                i++;
            }
            if (!bulundu) {
                Kelime yeni = new Kelime(kelime, 1,0,0);
                k.add(yeni);
                System.out.println("eklendi");
            }
        }
        else{
            Kelime yeni = new Kelime(kelime,1,0,0);
            k.add(yeni);
        }


    }
    private static void listeyiYazdir(){
        for (int i=0;i<k.size();i++){
            System.out.println("Kelime  : " + k.get(i).kelime);
            System.out.println("Frekans : " + k.get(i).frekans);
            System.out.println("*********************************");
        }
    }

    private static void veriyiTemizle(){
        for(int i=0;i<k.size();i++){
            String eleman = k.get(i).kelime;
            char[] c = eleman.toCharArray();
            String sonuc = "";
            for(int j=0;j<eleman.length();j++){
                char karakter = c[j];
                if(karakter != ',' && karakter != '.' && karakter != '/' && karakter != '*' &&
                        karakter != ';' && karakter != '"' && karakter !=':' && karakter != '-' && karakter != '_' &&
                karakter != '?' && karakter != '!' && karakter != '(' && karakter != ')' && karakter != '”' && karakter !='0' && karakter !='1'
                        && karakter !='2' && karakter !='3' && karakter !='4' && karakter !='5' && karakter !='6' && karakter !='7'
                        && karakter !='8' && karakter !='9'){
                    sonuc += karakter;
                }
            }
            if(sonuc == ""){
                k.remove(i);
            }else {
                k.get(i).kelime = sonuc;
            }
        }
    }



    public static void main(String[] args) {

        /*dosyaAc("C:\\Users\\casper\\Desktop\\makine_ogrenmesi\\1.txt");
        listeyiYazdir();
        System.out.println("Yeni Liste");
        System.out.println("///////////////////////////////////////");
        listeyiYazdir();*/
    }
}