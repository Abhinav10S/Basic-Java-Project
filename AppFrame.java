package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;

public class AppFrame extends JFrame implements ActionListener {
    
    JButton compressButton ; 
    JButton decompressButton ; 
     
    AppFrame (){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    compressButton = new JButton("Select File To Compresss");
    compressButton.setBounds(20,100,200,30);
    compressButton.addActionListener(this);

    decompressButton = new JButton("Select File To Decompresss");
    decompressButton.setBounds(20,100,200,30);
    decompressButton.addActionListener(this);

    this.add(compressButton);
    this.add(decompressButton);
    this.setSize(1000,500);
    this.getContentPane().setBackground(Color.blue);
    this.setVisible(true);
    }

    public void actionPerformed  (ActionEvent e){
        if (e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
           if (response==JFileChooser.APPROVE_OPTION){
            File file = new File (fileChooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
           try{
            compressor.method(file);
           }
           catch (Exception ee){
               JOptionPane.showMessageDialog(null, ee.toString());
           }
        }
    } 

    if (e.getSource()==decompressButton){
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
       if (response==JFileChooser.APPROVE_OPTION){
        File file = new File (fileChooser.getSelectedFile().getAbsolutePath());
        System.out.print(file);
       try{
        decompressor.method(file);
       }
       catch (Exception ee){
           JOptionPane.showMessageDialog(null, ee.toString());
       }
    }
}


    }

}

