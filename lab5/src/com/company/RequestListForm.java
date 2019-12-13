package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
public class RequestListForm extends JPanel {
    private JTable requestsTable;

    public RequestListForm() {

        requestsTable = new JTable();
        requestsTable.setRowHeight(30);

        this.add(new JScrollPane(requestsTable));
        requestsTable.setFillsViewportHeight(true);
    }

    public void updateTable(){
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Фамилия");
        model.addColumn("Адресс");
        model.addColumn("Номер телефона");
        model.addColumn("Дата рождения");
        model.addColumn("Пользователь");
        for (Request request : Main.bookRequests) {
            String[] row = new String[] {request.getSurname(), request.getAdress(), String.valueOf(request.getNumber()), String.valueOf(request.getBirth()), "Пользователь", request.getRequester().getName()};
            model.addRow(row);
        }

        requestsTable.setModel(model);
        model.fireTableDataChanged();
    }
}
