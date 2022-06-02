package br.com.fiap.elestation.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fiap.elestation.utils.StateEnum;
@Entity
public class Station {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String street;
	private String district;
	private String city;
	private StateEnum state;
	private Integer score;
	@ElementCollection
	private List<String> plugs; // { "Type1", "Type2", "css2", "CHAdeMO" };
	private Float price;

	public Station() {

	}

	public Station(String name, String street, String district, String city, StateEnum state, Integer score,
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
	
	public long getId() {
		return id;
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

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
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

	public void setScore(Integer score) {
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
		data.add(state.toString());
		data.add(score.toString());
		data.add(plugs.toString());
		data.add(price.toString());

		return data;
	}

}
