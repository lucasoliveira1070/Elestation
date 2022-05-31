package br.com.fiap.elestation.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TableListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int response = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse registro?");
			if (response == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				System.out.print("APAGAR produto com id = " + id);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
