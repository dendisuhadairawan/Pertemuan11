/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
/**
 *
 * @author hp
 */
public class SelectAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fasilitas perintah = new fasilitas();
 List<barang> list = perintah.SelectAll();
    for(barang barang : list){
 System.out.println(barang.getKode_barang());
 System.out.println(barang.getNama_barang());
 System.out.println(barang.getJumlah());
 System.out.println(barang.getHarga());
 System.out.println("-------------------------");
    }
    
}
}
