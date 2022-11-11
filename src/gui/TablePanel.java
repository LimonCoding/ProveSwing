package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Account;

public class TablePanel extends JPanel {
    
    private JTable table;
    private AccountTableModel tableModel;
    
    public TablePanel() {
        tableModel = new AccountTableModel();
        table = new JTable(tableModel);
        
        setLayout(new BorderLayout());
        
        add(table, BorderLayout.CENTER);
    }

    public void setData(List<Account> db) {
        tableModel.setData(db);
    }
    
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
