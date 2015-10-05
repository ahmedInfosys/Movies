package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_HALL database table.
 * 
 */
@Entity
@Table(name="M_HALL",schema="TESTDB")
@NamedQuery(name="MHall.findAll", query="SELECT m FROM MHall m")
public class MHall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int availability;

	@Column(name="MAX_CAPACITY")
	private int maxCapacity;

	private String name;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to MTheatre
	@ManyToOne
	@JoinColumn(name="THEATRE_ID")
	private MTheatre MTheatre;

	//bi-directional many-to-one association to MShowtime
	@OneToMany(mappedBy="MHall")
	private List<MShowtime> MShowtimes;

	public MHall() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAvailability() {
		return this.availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public int getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MTheatre getMTheatre() {
		return this.MTheatre;
	}

	public void setMTheatre(MTheatre MTheatre) {
		this.MTheatre = MTheatre;
	}

	public List<MShowtime> getMShowtimes() {
		return this.MShowtimes;
	}

	public void setMShowtimes(List<MShowtime> MShowtimes) {
		this.MShowtimes = MShowtimes;
	}

	public MShowtime addMShowtime(MShowtime MShowtime) {
		getMShowtimes().add(MShowtime);
		MShowtime.setMHall(this);

		return MShowtime;
	}

	public MShowtime removeMShowtime(MShowtime MShowtime) {
		getMShowtimes().remove(MShowtime);
		MShowtime.setMHall(null);

		return MShowtime;
	}

}