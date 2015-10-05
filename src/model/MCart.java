package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the M_CART database table.
 * 
 */
@Entity
@Table(name="M_CART",schema="TESTDB")
@NamedQuery(name="MCart.findAll", query="SELECT m FROM MCart m")
public class MCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int quantity;

	@Column(name="TOTAL_PRICE")
	private double totalPrice;

	//bi-directional many-to-one association to MAdmin
	@ManyToOne
	@JoinColumn(name="ADMIN_ID")
	private MAdmin MAdmin;

	//bi-directional many-to-one association to MShowtime
	@ManyToOne
	@JoinColumn(name="SHOWTIME_ID")
	private MShowtime MShowtime;

	//bi-directional many-to-one association to MTicket
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	private MTicket MTicket;

	public MCart() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public MAdmin getMAdmin() {
		return this.MAdmin;
	}

	public void setMAdmin(MAdmin MAdmin) {
		this.MAdmin = MAdmin;
	}

	public MShowtime getMShowtime() {
		return this.MShowtime;
	}

	public void setMShowtime(MShowtime MShowtime) {
		this.MShowtime = MShowtime;
	}

	public MTicket getMTicket() {
		return this.MTicket;
	}

	public void setMTicket(MTicket MTicket) {
		this.MTicket = MTicket;
	}

}