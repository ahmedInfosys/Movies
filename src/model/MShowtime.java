package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_SHOWTIME database table.
 * 
 */
@Entity
@Table(name="M_SHOWTIME",schema="TESTDB")
@NamedQuery(name="MShowtime.findAll", query="SELECT m FROM MShowtime m")
public class MShowtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="M_DATE")
	private String mDate;

	private String status;

	@Column(name="TIME_FROM")
	private String timeFrom;

	@Column(name="TIME_TO")
	private String timeTo;

	//bi-directional many-to-one association to MCart
	@OneToMany(mappedBy="MShowtime")
	private List<MCart> MCarts;

	//bi-directional many-to-one association to MHall
	@ManyToOne
	@JoinColumn(name="HALL_ID")
	private MHall MHall;

	//bi-directional many-to-one association to MMovy
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private MMovy MMovy;

	//bi-directional many-to-one association to MUserticket
	@OneToMany(mappedBy="MShowtime")
	private List<MUserticket> MUsertickets;

	public MShowtime() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMDate() {
		return this.mDate;
	}

	public void setMDate(String mDate) {
		this.mDate = mDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeFrom() {
		return this.timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return this.timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public List<MCart> getMCarts() {
		return this.MCarts;
	}

	public void setMCarts(List<MCart> MCarts) {
		this.MCarts = MCarts;
	}

	public MCart addMCart(MCart MCart) {
		getMCarts().add(MCart);
		MCart.setMShowtime(this);

		return MCart;
	}

	public MCart removeMCart(MCart MCart) {
		getMCarts().remove(MCart);
		MCart.setMShowtime(null);

		return MCart;
	}

	public MHall getMHall() {
		return this.MHall;
	}

	public void setMHall(MHall MHall) {
		this.MHall = MHall;
	}

	public MMovy getMMovy() {
		return this.MMovy;
	}

	public void setMMovy(MMovy MMovy) {
		this.MMovy = MMovy;
	}

	public List<MUserticket> getMUsertickets() {
		return this.MUsertickets;
	}

	public void setMUsertickets(List<MUserticket> MUsertickets) {
		this.MUsertickets = MUsertickets;
	}

	public MUserticket addMUserticket(MUserticket MUserticket) {
		getMUsertickets().add(MUserticket);
		MUserticket.setMShowtime(this);

		return MUserticket;
	}

	public MUserticket removeMUserticket(MUserticket MUserticket) {
		getMUsertickets().remove(MUserticket);
		MUserticket.setMShowtime(null);

		return MUserticket;
	}

}