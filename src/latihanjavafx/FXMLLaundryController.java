/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mila
 */
public class FXMLLaundryController implements Initializable {

    @FXML
    private TextField Nama;
    @FXML
    private TextField Alamat;
    @FXML
    private TextField Berat;
    @FXML
    private TextField Tanggal;
    @FXML
    private RadioButton CK;
    @FXML
    private ToggleGroup PilihanPaket;
    @FXML
    private RadioButton CKS;
    @FXML
    private RadioButton S;
    @FXML
    private Button buttonOke;
    @FXML
    private TextArea Hasil;
    @FXML
    private Button buttonHapus;
    @FXML
    private TextField Telp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Oke(ActionEvent event) {
        String paket="";
        if(CK.isSelected())
           paket = "Cuci Kering";
        else if (CKS.isSelected())
           paket = "Cucui Kering Setrika";
        else if(S.isSelected())
           paket = "Setrika";
        else 
           paket ="";
        
        if(!(CK.isSelected() || CKS.isSelected() || S.isSelected() )){
            JOptionPane.showMessageDialog(null, "Harap Pilih Paket Layanan");
        }else{
            int harga =0;
            String nama = Nama.getText();
            String alamat = Alamat.getText();
            String berat = Berat.getText()+"kg";
            String tanggal = Tanggal.getText();
            int hitung = Integer.parseInt(Berat.getText());
            
            if (CK.isSelected()){
                harga = hitung*5000;}
            if (CKS.isSelected()){
                harga = hitung*6000;}
            if (S.isSelected()){
                harga = hitung*4000;
            }
            
            String nohp = Telp.getText();
            
            Hasil.setText("Nama  : "+nama+"\n"+"Alamat : "+alamat+"\n"+"Berat Cucian : "+berat+"\n"+"Nomor Telp : "+nohp+"\n"+"Pilihan Paket : "+paket+"\n"+"Tanggal Pengambilan : "+tanggal+"\n"+
                    "Pembayaran yang Harus Dibayar : "+harga);
            
        }
        
    }

    @FXML
    private void Hapus(ActionEvent event) {
        Nama.setText("");
        Alamat.setText("");
        Berat.setText("");
        Telp.setText("");
        CK.setSelected(false);
        CKS.setSelected(false);
        S.setSelected(false);
        Tanggal.setText("");
        
        
    }
    
}
