package br.com.fiap.elestation.view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.elestation.controller.ButtonListener;
import br.com.fiap.elestation.controller.TableListener;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel registryPanel = new JPanel();
	private JPanel queryPanel = new JPanel();

	private JTextField txtName = new JTextField(50);
	private JTextField txtStreet = new JTextField(50);
	private JTextField txtDistrict = new JTextField(40);
	private JTextField txtCity = new JTextField(30);
	private JTextField txtState = new JTextField(30);
	private JTextField txtPrice = new JTextField(20);
	private JButton btnSave = new JButton("Salvar");

	StarRater starRater = new StarRater();
	float score;
	private String[] plugType = { "Type1", "Type2", "css2", "CHAdeMO" };
	private List<String> avaiblePlugs = new ArrayList<String>();

	String[] columns = { "Nome", "Endereço", "Avaliação", "Tipo de Plug", "Preço kWh" };
	DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	JTable table = new JTable(tableModel);

	public Window() {
		setSize(1050, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void init() {
		starRater.addMouseListener(null);
		registryPanel.add(new JLabel("Nome"));
		registryPanel.add(txtName);
		registryPanel.add(new JLabel("Rua"));
		registryPanel.add(txtStreet);
		registryPanel.add(new JLabel("Bairro"));
		registryPanel.add(txtDistrict);
		registryPanel.add(new JLabel("Cidade"));
		registryPanel.add(txtCity);
		registryPanel.add(new JLabel("Estado"));
		registryPanel.add(txtState);
		registryPanel.add(new JLabel("Preço kWh"));
		registryPanel.add(txtPrice);

		registryPanel.add(starRater);

		for (int i = 0; i < plugType.length; i++) {
			registryPanel.add(new JCheckBox(plugType[i]));
		}

		registryPanel.add(btnSave);
		registryPanel.setLayout(new BoxLayout(registryPanel, BoxLayout.Y_AXIS));
		TableListener tableListener = new TableListener();
		table.addMouseListener(tableListener);
		table.setDefaultEditor(Object.class, null);

		queryPanel.add(new JScrollPane(table));
		this.setLayout(new FlowLayout());
		this.add(registryPanel);
		this.add(queryPanel);

		ButtonListener listener = new ButtonListener(this);
		btnSave.addActionListener(listener);
		setVisible(true);
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtStreet() {
		return txtStreet;
	}

	public JTextField getTxtDistrict() {
		return txtDistrict;
	}

	public JTextField getTxtCity() {
		return txtCity;
	}

	public JTextField getTxtState() {
		return txtState;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public String[] getPlugType() {
		return plugType;
	}

	public StarRater getStarRater() {
		return starRater;
	}

	public List<String> getAvaiblePlugs() {
		return avaiblePlugs;
	}

	public JPanel getRegistryPanel() {
		return registryPanel;
	}

	public float getScore() {
		return score;
	}

}
