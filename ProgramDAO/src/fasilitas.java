/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class fasilitas {
    private Connection koneksi; 
 public fasilitas() {
 koneksi = koneksidatabase.getKoneksi();
 }
 public void insert(barang barang){
 PreparedStatement prepare = null;
 
 try {
     String sql ="INSERT INTO barang  (kode_barang,nama_barang,jumlah,harga)VALUES(?,?,?,?)";
    prepare = (PreparedStatement) koneksi.prepareStatement(sql);
    prepare.setString(1, barang.getKode_barang());
    prepare.setString(2, barang.getNama_barang());
    prepare.setInt(3, barang.getJumlah());
    prepare.setLong(4, barang.getHarga());
    prepare.executeUpdate();
    
     System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){
    System.out.println("Prepare statement gagal dibuat"); 
    System.out.println("Pesan : " + ex.getMessage());
 }finally{
    if (prepare != null){
 try{
    prepare.close();
     System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
     System.out.println("Prepare statemen gagal ditutup"); 
     System.out.println("Pesan : " + ex.getMessage());

        }
      }
    }
 }
public void update(barang barang){
 PreparedStatement prepare = null;
 try {
        String sql ="UPDATE barang SET nama_barang=?,jumlah=?,harga=? WHERE kode_barang=?";
    prepare = (PreparedStatement) koneksi.prepareStatement(sql);
    prepare.setString(1, barang.getNama_barang());
    prepare.setInt(2, barang.getJumlah());
    prepare.setLong(3, barang.getHarga());
    prepare.setString(4, barang.getKode_barang());
    prepare.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){
        System.out.println("Prepare statement gagal dibuat"); 
        System.out.println("Pesan : " + ex.getMessage());
 }finally{
 if (prepare != null){
 try{
 prepare.close();
        System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
         }
       }
    }
 } 
public void delete(String kode_barang){
 PreparedStatement prepare = null;
 try {
         String sql ="DELETE FROM barang WHERE kode_barang=?";
    prepare = (PreparedStatement) koneksi.prepareStatement(sql);
    prepare.setString(1, kode_barang);
    prepare.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");
 }catch(SQLException ex){
        System.out.println("Prepare statement gagal dibuat"); 
        System.out.println("Pesan : " + ex.getMessage());
 }finally{
 if (prepare != null){
 try{
    prepare.close();
        System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());

            }
        }
     }
}
public List<barang> SelectAll(){
    PreparedStatement prepare = null;
    ResultSet result = null;
    List<barang> list = new ArrayList<>();
 try {
    String sql ="SELECT * FROM barang";
    prepare = (PreparedStatement) koneksi.prepareStatement(sql);
    result = prepare.executeQuery();
 while (result.next()){
    barang barang = new barang();
     barang.setKode_barang(result.getString("Kode_barang"));
    barang.setNama_barang(result.getString("nama_barang"));
    barang.setJumlah(result.getInt("jumlah"));
    barang.setHarga(result.getLong("harga"));
    list.add(barang);
 }
        System.out.println("Prepare statement berhasil dibuat");
 return list;
 }catch(SQLException ex){
        System.out.println("Prepare statement gagal dibuat"); 
        System.out.println("Pesan : " + ex.getMessage());
 return list;
 }finally{
 if (prepare != null){
 try{
     prepare.close();
        System.out.println("Prepare statemen berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Prepare statemen gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
 }
 }
 if (result != null){

try{
    result.close();
        System.out.println("Resultset berhasil ditutup");
 }catch(SQLException ex){
        System.out.println("Resultset gagal ditutup"); 
        System.out.println("Pesan : " + ex.getMessage());
                }
            }
        }
    }
}
