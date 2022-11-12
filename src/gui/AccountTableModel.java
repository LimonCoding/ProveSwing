package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Account;

public class AccountTableModel extends AbstractTableModel {
    
    private List<Account> db;
    private String[] colNames = {"ID", "ALIAS", "LEVEL"};

    public void setData(List<Account> db) {
        this.db = db;
    }
    
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Account account = db.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return account.getId();
            case 1: 
                return account.getAlias();
            case 2: 
                return account.getLevel();
        }
        return null;
    }

}
