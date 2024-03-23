//Raffi adyatma
//235150400111005
//SI-A

import java.util.ArrayList;

public class Matkul {

    private String nama,
                   kode;

    private ArrayList<Byte>    nilai = new ArrayList<>();
    private ArrayList<Mahasiswa> mhs = new ArrayList<>();

    public Matkul(){}
    public Matkul(String nama, String kode){
        this.nama  = nama;
        this.kode  = kode;
    }

    // menambahkan mahasiswa
    public void addMHS(Mahasiswa mhs){
        this.mhs.add(mhs);
        this.nilai.add((byte)0);
    }
    public void addMHS(Mahasiswa mhs, byte nilai){
        this.mhs.add(mhs);
        this.nilai.add(nilai);
    }

    // mendisplay info seluruh mahasiswa yg mengikuti MK
    public void infoMHS(){
        for(int i=0; i<mhs.size(); i++){
            System.out.println(mhs.get(i).getNim() +" | "+ mhs.get(i).getNama() +"  ("+ angkaToHuruf(i) +")");
        }
    }

    // set nilai satu mahasiswa yg dipilih
    public void setNilai(String mhs, byte nilai){
        // mengecek setiap nama dalam arraylist lalu mengubah nilai di arraylist nilai dengan index sama
        for(int i=0; i<this.mhs.size(); i++){
            if(this.mhs.get(i).getNama().equalsIgnoreCase(mhs)){
                this.nilai.set(i, nilai);
                break;
            }
        }
    }

    // return nilai
    public char getNilai(String mhs){
        // mengecek setiap nama dalam arraylist lalu mengubah nilai di arraylist nilai dengan index sama
        for(int i=0; i<this.mhs.size(); i++){
            if(this.mhs.get(i).getNama().equalsIgnoreCase(mhs)){
                return angkaToHuruf(i);
                
            }
        }
        return '0';
    }


    //mengubah nilai angka ke huruf 
    public char angkaToHuruf(int index){
        char nilai = ' ';

             if(this.nilai.get(index)>=81 && this.nilai.get(index)<=100) nilai = 'A';
        else if(this.nilai.get(index)>=61 && this.nilai.get(index)<=80)  nilai = 'B';
        else if(this.nilai.get(index)>=51 && this.nilai.get(index)<=60)  nilai = 'C';
        else if(this.nilai.get(index)>=41 && this.nilai.get(index)<=50)  nilai = 'D';
        else if(this.nilai.get(index)>=0 && this.nilai.get(index)<=40)   nilai = 'E';
        
        return nilai;
    }



    
    
    public String getKode() {
        return kode;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
}