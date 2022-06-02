package br.com.fiap.elestation.controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import br.com.fiap.elestation.dao.StationDao;
import br.com.fiap.elestation.model.Station;
import br.com.fiap.elestation.utils.StateEnum;
import br.com.fiap.elestation.view.Window;

public class ButtonListener implements ActionListener {
	private Window view;
	StationDao dao = new StationDao();

	public ButtonListener(Window view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Station station = new Station();
			station.setName(view.getTxtName().getText());
			station.setStreet(view.getTxtStreet().getText());
			station.setDistrict(view.getTxtDistrict().getText());
			station.setCity(view.getTxtCity().getText());
			station.setState(StateEnum.valueOf(view.getComboState().getSelectedItem().toString()));
			station.setScore(view.getScore());
			station.setPlugs(manageCheckedCheckboxes(view.getRegistryPanel()));
			station.setPrice(Float.valueOf(view.getTxtPrice().getText().toString()));
			
			dao.insert(station);
			
			view.loadData();
			

		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Por favor, verifique se os dados estão corretos", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static List<String> manageCheckedCheckboxes(final Container c) {
		Component[] comps = c.getComponents();
		List<String> checkedTexts = new ArrayList<String>();

		for (Component comp : comps) {

			if (comp instanceof JCheckBox) {
				JCheckBox box = (JCheckBox) comp;
				if (box.isSelected()) {

					String text = box.getText();
					checkedTexts.add(text);
				}
			}
		}

		return checkedTexts;

	}

}
