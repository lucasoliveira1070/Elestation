package br.com.fiap.elestation.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.elestation.dao.StationDao;
import br.com.fiap.elestation.model.Station;
import br.com.fiap.elestation.view.Window;

public class TableListener implements MouseListener {
	
	private Window view;
	StationDao dao = new StationDao();

	public TableListener(Window view) {
		this.view = view;
	} 

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja ordenar a consulta por estado?");
			if (resposta == JOptionPane.YES_OPTION) {
				view.loadDataByState();			
			}

		}
		if (e.getClickCount() == 2) {
			int response = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse registro?");
			if (response == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				Station station = dao.find(Long.parseLong(id));
				dao.delete(station);
				view.loadData();
				
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
