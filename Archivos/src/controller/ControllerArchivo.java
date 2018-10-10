
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelArchivo;
import view.ViewArchivo;
import javax.swing.JFileChooser;

public class ControllerArchivo implements ActionListener {
    
    private final ModelArchivo modelArchivo;
    private final ViewArchivo viewArchivo;

    public ControllerArchivo(ModelArchivo modelArchivo, ViewArchivo viewArchivo) {
        this.modelArchivo = modelArchivo;
        this.viewArchivo = viewArchivo;
        
        viewArchivo.jmi_open.addActionListener(this);
        viewArchivo.jmi_save.addActionListener(this);
        viewArchivo.jmi_cifrar.addActionListener(this);
        viewArchivo.jmi_descifrar.addActionListener(this);
        initComponents();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewArchivo.jmi_open){
            selectPath();
            openFile();
        }
        else if (e.getSource() == viewArchivo.jmi_save){
            savePath();
            saveFile();
        }
        else if (e.getSource() == viewArchivo.jmi_cifrar){
            cifrar();
        }
        else if (e.getSource() == viewArchivo.jmi_descifrar){
            descifrar();
        }
    }
    public void openFile(){
        modelArchivo.readFile(modelArchivo.getPath());
        viewArchivo.jta_file.setText(modelArchivo.getMessage());
        
    }
    public void saveFile(){
        modelArchivo.setMessage(viewArchivo.jta_file.getText());
        modelArchivo.writeFile(modelArchivo.getPath(), modelArchivo.getMessage());
    }
    
    public void selectPath(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        modelArchivo.setPath("" + chooser.getSelectedFile());
    }
    
    public void savePath(){
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        modelArchivo.setPath("" + chooser.getSelectedFile());
    }
    
    public void initComponents(){
        viewArchivo.setTitle("Bloc de notas Chay");
        viewArchivo.setVisible(true);
        viewArchivo.setLocationRelativeTo(null);
        
    }

    public void cifrar() {
        String total = "";
        for (int i = 0; i < viewArchivo.jta_file.getText().length(); i++){
            char character = viewArchivo.jta_file.getText().charAt(i);           
            int value = (int) character;  
            int value1 = value + 5;
            char value2 = (char) value1; 
            total = total + value2;
        }
        viewArchivo.jta_file.setText(total);
    }

    public void descifrar() {
        String total = "";
        for (int i = 0; i < viewArchivo.jta_file.getText().length(); i++){
            char character = viewArchivo.jta_file.getText().charAt(i);           
            int value = (int) character;  
            int value1 = value - 5;
            char value2 = (char) value1; 
            total = total + value2;
        }
        viewArchivo.jta_file.setText(total);
    }
    
}
