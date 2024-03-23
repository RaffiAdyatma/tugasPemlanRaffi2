//Raffi adyatma
//235150400111005
//SI-A

import java.util.ArrayList;

public class Mahasiswa {
    
    private String nama,
                   nim;
    private ArrayList<Matkul> mk = new ArrayList<>();
    
    public Mahasiswa(){}
    public Mahasiswa(String nama, String nim){
        this.nim  = nim;
        this.nama = nama;
    }



    // menambahkan mata kuliah 
    public void addMK(Matkul mk){
        this.mk.add(mk);
    }

    //display info mata kuliah yang diikuti mahasiswa
    public void infoMK(){
        System.out.println("Kode  |  mata kuliah  |  Nilai"+
                         "\n------------------------------");
        for(int i=0; i<mk.size(); i++){
            System.out.println(mk.get(i).getKode()+"  |  "+mk.get(i).getNama()+"  |  "+mk.get(i).getNilai(nama));
        }
    }


// seetter getter
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    
    public String getNamaMk(int index) {
        return mk.get(index).getNama();
    }
    public int getSizeMk() {
        return mk.size();
    }
}
