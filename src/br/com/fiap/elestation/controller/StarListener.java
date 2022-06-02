package br.com.fiap.elestation.controller;

import br.com.fiap.elestation.view.Window;

public class StarListener implements br.com.fiap.elestation.view.StarRater.StarListener {
	
	private Window view;
	
	public StarListener(Window view) {
		this.view = view;
	}

	@Override
	public void handleSelection(int selection) {
		view.setScore(selection);
	}

}
