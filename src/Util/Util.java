package Util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe com métodos úteis, como data e hora do sistema, atualizar JTable
 * @author cassio
 */
public class Util {
    public Util(){}
    
    Calendar cal = new GregorianCalendar();
    //Método para recuperar a data do sistema
    public String dataSistema(){
        String data = "";
        
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int ano = cal.get(Calendar.YEAR);
        
        data = dia+"/"+(mes+1)+"/"+ano;
        
        return data;
    }
    
    //Método para recuperar a hora do sistema
    public String horarioSistema(){
        String horario = "";
        
        int hora = cal.get(Calendar.HOUR);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        
        horario = hora+":"+minuto+":"+segundo;
        
        return horario;
    }
    
    //Método para limpar tabelas
    public void cleanJTable(JTable table){
        DefaultTableModel tblRemove = (DefaultTableModel)table.getModel();
        int i, count;
        
        count = tblRemove.getRowCount();
        //Verifica se o número de linhas é maior que 0
        if (tblRemove.getRowCount() > 0){
            for (i = 0; i < count; i++){
                tblRemove.removeRow(0);
            }    
        }
    }
}
