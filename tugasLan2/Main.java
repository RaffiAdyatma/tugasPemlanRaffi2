//Raffi adyatma
//235150400111005
//SI-A

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // addMK , addMHS , setMK , setNilai , infoMHS , infoMK , exit 
    // infoMHS = display info setiap mahasiswa dan MK serta nilai dari MK yg dimiliki
    // infoMK  = display info setiap mahasiswa yang berada di setiap MK

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Mahasiswa> mhs = new ArrayList<>();
        ArrayList<Matkul> mk = new ArrayList<>();

        String pilihan;
        do{
            System.out.println("masukkan perintah\naddMHS , addMK , setMK , setNilai , infoMHS , infoMK , exit"+
                            "\n(tidak case sensitif)");
            pilihan = input.nextLine();
            switch (pilihan.toUpperCase()) {

                case "ADDMHS":
                // menambahkan mahasiswa
                    mhs.add(new Mahasiswa());
                    
                    System.out.print("masukkan nama mahasiswa : ");
                    mhs.get(mhs.size()-1).setNama(input.nextLine());

                    System.out.print("masukkan nim mahasiswa  : ");
                    mhs.get(mhs.size()-1).setNim(input.nextLine());
                    
                    System.out.println("set mata kuliah untuk mahasiswa ini?  y/t");
                    String ulang = input.nextLine();
                    if(ulang.equalsIgnoreCase("y")){
                        do {
                            System.out.print("masukkan nama mata kuliah  : ");
                            String namamk = input.nextLine();
                            boolean cek=false;
                            int index=0;

                            // looping mengecek semua mk untuk menemukan yg sama
                            for(int i=0; i<mk.size(); i++){
                                if(namamk.equalsIgnoreCase(mk.get(i).getNama())){
                                    cek = true;
                                    index = i;
                                    break;
                                }
                            }
                            // jika ditemukan maka akan menambahkan mahasiswa kedalam mk yg sudah ada
                            if(cek==true){
                                mhs.get(mhs.size()-1).addMK(mk.get(index));
                                System.out.print("masukkan nilai mata kuliah : ");
                                mk.get(index).addMHS(mhs.get(mhs.size()-1), input.nextByte());
                                input.nextLine();
                            }
                            else{
                                mk.add(new Matkul());
                                mhs.get(mhs.size()-1).addMK(mk.get(mk.size()-1));
                            
                                mk.get(mk.size()-1).setNama(namamk);

                                System.out.print("masukkan kode mata kuliah  : ");
                                mk.get(mk.size()-1).setKode(input.nextLine());

                                System.out.print("masukkan nilai mata kuliah : ");
                                mk.get(mk.size()-1).addMHS(mhs.get(mhs.size()-1), input.nextByte());
                                input.nextLine();
                            }
                            System.out.println("lagi? y/t");
                            ulang = input.nextLine();
                        } while (ulang.equalsIgnoreCase("y"));
                    } 

                    break;

                case "ADDMK":
                // menambahkan objek matakuliah
                    do {
                    mk.add(new Matkul());

                    System.out.print("masukkan nama mata kuliah  : ");
                    mk.get(mk.size()-1).setNama(input.nextLine());

                    System.out.print("masukkan kode mata kuliah  : ");
                    mk.get(mk.size()-1).setKode(input.nextLine());
                        
                    System.out.println("lagi? y/t");
                    ulang = input.nextLine();
                    } while (ulang.equalsIgnoreCase("y"));
                    break;

                case "SETMK":
                // menambahkan mk ke mahasiswa
                    System.out.println("list nama mahasiswa :");
                    for (int i=0; i<mhs.size(); i++) {
                        System.out.println((i+1)+". "+ mhs.get(i).getNama());
                    }
                    System.out.print("masukkan nama mahasiswa : ");
                    String namacek = input.nextLine();
                    boolean cek = false;
                    int index = 0;

                    for (int i=0; i<mhs.size(); i++) {
                        // mengecek setiap nama dalam list mhs
                        if(namacek.equalsIgnoreCase(mhs.get(i).getNama())){
                            cek = true;
                            index = i;
                            break;
                        }
                    }
                    if(cek==true){
                        System.out.println("list mata kuliah yang terdaftar :");
                        for (int i=0; i<mk.size(); i++) {
                            System.out.println((i+1)+". "+ mk.get(i).getNama());
                        }
                        // menambahkan mk kedalam list mahasiswa
                        System.out.print("masukkan nama mata kuliah yang diikuti mahasiswa : ");
                        namacek = input.nextLine();
                        for (int i=0; i<mhs.size(); i++) {
                            // mengecek jika ada mk dalam list lalu menambahkan nya dalam list obyek mhs
                            // lalu menambahkan mhs dan nilainya kedalam list obyek mk
                            if(namacek.equalsIgnoreCase(mk.get(i).getNama())){
                                mhs.get(index).addMK(mk.get(i));
                                System.out.print("masukkan nilai mahasiswa : ");
                                mk.get(i).addMHS(mhs.get(index), input.nextByte());
                                input.nextLine();
                                break;
                            }
                        }
                    } else{System.out.println("tidak ditemukan");}
                    break;
                    
                case "SETNILAI":
                System.out.println("list nama mahasiswa :");
                for (int i=0; i<mhs.size(); i++) {
                    System.out.println((i+1)+". "+ mhs.get(i).getNama());
                }
                System.out.print("masukkan nama mahasiswa : ");
                namacek = input.nextLine();
                cek = false;
                index = 0;

                for (int i=0; i<mhs.size(); i++) {
                    if(namacek.equalsIgnoreCase(mhs.get(i).getNama())){
                        cek = true;
                        index = i;
                        break;
                    }
                }
                if(cek==true){
                    System.out.println("list mata kuliah yang terdaftar :");
                    for (int i=0; i<mhs.get(index).getSizeMk(); i++) {
                        System.out.println((i+1)+". "+ mhs.get(index).getNamaMk(i));
                    }
                    // menambahkan mk kedalam list mahasiswa
                    System.out.print("masukkan nama mata kuliah yang diikuti mahasiswa : ");
                    String namamkcek = input.nextLine();
                    for (int i=0; i<mk.size(); i++) {
                        // mengecek jika ada mk dalam list lalu menambahkan nya dalam list obyek mhs
                        // lalu menambahkan nilai kedalam list obyek mk
                        if(namamkcek.equalsIgnoreCase(mk.get(i).getNama())){
                            System.out.print("masukkan nilai mahasiswa : ");
                            mk.get(i).setNilai(namacek, input.nextByte());
                            input.nextLine();
                            break;
                        }
                    }
                }
                    break;
                case "INFOMHS":
                    System.out.println("\n========================================");
                    for(int i=0; i<mhs.size(); i++){
                        System.out.println(mhs.get(i).getNim() +"  "+mhs.get(i).getNama() +" :");
                        mhs.get(i).infoMK();
                        System.out.println("________________________________________");
                    }
                    System.out.println("========================================");
                    break;
                case "INFOMK":
                    System.out.println("\n========================================");
                    for(int i=0; i<mk.size(); i++){
                        System.out.println(mk.get(i).getKode()+"  "+mk.get(i).getNama() +" :");
                        mk.get(i).infoMHS();
                        System.out.println("________________________________________");
                    }
                    System.out.println("========================================");
                    break;
                case "EXIT":
                    break;
                default:
                    System.out.println("perintah tidak dikenali, pastikan tidak salah tulis dan coba lagi");
                    break;
            }
            System.out.println();
        }while (!pilihan.equalsIgnoreCase("exit"));
        
        input.close();
    }

}
