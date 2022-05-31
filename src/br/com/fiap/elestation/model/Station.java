package br.com.fiap.elestation.model;

import java.util.List;
import java.util.Vector;

public class Station {

	private Long id;
	private String name;
	private String street;
	private String district;
	private String city;
	private String state;
	private Float score;
	private List<String> plugs; // { "Type1", "Type2", "css2", "CHAdeMO" };
	private Float price;

	public Station() {

	}

	public Station(String name, String street, String district, String city, String state, Float score,
			List<String> plugs, Float price) {
		this.name = name;
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
		this.score = score;
		this.plugs = plugs;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<String> plugs) {
		this.plugs = plugs;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + "-" + street + "-" + district + "-" + city + "-" + state + " - " + score + " - " + plugs + " - "
				+ price;
	}

	public Vector<String> getData() {

		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(name);
		data.add(street);
		data.add(district);
		data.add(city);
		data.add(state);
		data.add(score.toString());
		data.add(plugs.toString());
		data.add(price.toString());

		return data;
	}

}
