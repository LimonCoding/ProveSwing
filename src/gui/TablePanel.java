package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Account;

public class TablePanel extends JPanel {
    
    private JTable table;
    private AccountTableModel tableModel;
    private JScrollPane scrollPane;
    
    public TablePanel() {
        tableModel = new AccountTableModel();
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        fontSettings();
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void fontSettings() {
        table.setFont(new Font("Cabin Bold", 30, 30));
        table.setToolTipText("Seleziona un account!");
        table.setForeground(Color.BLACK);
    }

    public void setData(List<Account> db) {
        tableModel.setData(db);
    }
    
    public JTable getTable() {
        return table;
    }
    
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
