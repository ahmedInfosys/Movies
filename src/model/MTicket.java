package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_TICKETS database table.
 * 
 */
@Entity
@Table(name="M_TICKETS",schema="TESTDB")
@NamedQuery(name="MTicket.findAll", query="SELECT m FROM MTicket m")
public class MTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="DATE_FROM")
	private String dateFrom;

	@Column(name="DATE_TO")
	private String dateTo;

	private double price;

	//bi-directional many-to-one association to MCart
	@OneToMany(mappedBy="MTicket")
	private List<MCart> MCarts;

	//bi-directional many-to-one association to MMovy
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private MMovy MMovy;

	//bi-directional many-to-one association to MUserticket
	@OneToMany(mappedBy="MTicket")
	private List<MUserticket> MUsertickets;

	public MTicket() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<MCart> getMCarts() {
		return this.MCarts;
	}

	public void setMCarts(List<MCart> MCarts) {
		this.MCarts = MCarts;
	}

	public MCart addMCart(MCart MCart) {
		getMCarts().add(MCart);
		MCart.setMTicket(this);

		return MCart;
	}

	public MCart removeMCart(MCart MCart) {
		getMCarts().remove(MCart);
		MCart.setMTicket(null);

		return MCart;
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
		MUserticket.setMTicket(this);

		return MUserticket;
	}

	public MUserticket removeMUserticket(MUserticket MUserticket) {
		getMUsertickets().remove(MUserticket);
		MUserticket.setMTicket(null);

		return MUserticket;
	}

}