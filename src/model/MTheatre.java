package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_THEATRE database table.
 * 
 */
@Entity
@Table(name="M_THEATRE",schema="TESTDB")
@NamedQuery(name="MTheatre.findAll", query="SELECT m FROM MTheatre m")
public class MTheatre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String address;

	private String city;

	private String name;

	private String phonenumber;

	@Column(name="\"STATE\"")
	private String state;

	private String zipcode;

	//bi-directional many-to-one association to MHall
	@OneToMany(mappedBy="MTheatre")
	private List<MHall> MHalls;

	public MTheatre() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<MHall> getMHalls() {
		return this.MHalls;
	}

	public void setMHalls(List<MHall> MHalls) {
		this.MHalls = MHalls;
	}

	public MHall addMHall(MHall MHall) {
		getMHalls().add(MHall);
		MHall.setMTheatre(this);

		return MHall;
	}

	public MHall removeMHall(MHall MHall) {
		getMHalls().remove(MHall);
		MHall.setMTheatre(null);

		return MHall;
	}

}