import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String tinggi,berat;
        float t=0 , b=0;
        boolean kondisi;
        Scanner scan = new Scanner(System.in);
        head();
        do{
            do{
                System.out.print("Tinggi Badan anda : " );
                tinggi = scan.next();
                tinggi = cekInputan(tinggi);
                if(!tinggi.isEmpty()){
                    kondisi = true;
                    t = Float.parseFloat(tinggi);
                    if(t >= 100){
                        t = t / 100;
                    }
                }else{
                    kondisi= false;
                    System.out.println("Masukan nilai dalam bentuk angak !!!");
                }
            }while (!kondisi);
            do{
                System.out.print("Berat badan anda : ");
                berat = scan.next();
                berat = cekInputan(berat);
                if(!berat.isEmpty()){
                    b = Float.parseFloat(berat);
                }else{
                    kondisi= false;
                    System.out.println("Masukan nilai dalam bentuk angak !!!");
                }
            }while (!kondisi);
            if( b != 0 && t!= 0){
                kondisi = true;
                int keriteria = hitungKriteria(t,b);
                if(keriteria <= 18){
                    System.out.println("Anda termasuk KURUS");
                }else if ( keriteria > 18 && keriteria <= 25){
                    System.out.println("Anda termasuk Normal");
                }else if( keriteria > 25 && keriteria <= 30){
                    System.out.println("Anda termasuk Gemuk");
                }else{
                    System.out.println("Anda Gemuk (Obesitas)");
                }
            }
        }while (!kondisi);



    }

    private static int hitungKriteria(float t, float b) {
        float IMT = (float) (b / Math.pow(t,2));
        int hasil = (int) IMT;
        return  hasil;
    }

    private static String cekInputan(String input) {
        int ascii_start = 46, ascii_end = 57;
        String kata = input;
        boolean kondisi = true;
        for (int i = 0; i < input.length(); i++) {
            while (kondisi) {
                if ((int) input.charAt(i) == ascii_start && (int) input.charAt(i) != 47) {
                    if (i != input.length() - 1) {
                        kondisi = false;
                    } else {
                        return kata;
                    }
                } else {
                    if (ascii_start == ascii_end)
                        kondisi = false;
                    ascii_start++;
                }
            }
            ascii_start = 46;
            kondisi = true;
        }
        return "";
    }

    private static void head() {
        System.out.println("=====================================");
        System.out.println("|\t\t KRITERIA KEGEMUKAN \t\t|");
        System.out.println("=====================================");
    }
}
