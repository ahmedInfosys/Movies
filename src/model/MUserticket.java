package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the M_USERTICKETS database table.
 * 
 */
@Entity
@Table(name="M_USERTICKETS",schema="TESTDB")
@NamedQuery(name="MUserticket.findAll", query="SELECT m FROM MUserticket m")
public class MUserticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="RESERVE_DATE")
	private String reserveDate;

	//bi-directional many-to-one association to MAdmin
	@ManyToOne
	@JoinColumn(name="ADMINE_ID")
	private MAdmin MAdmin;

	//bi-directional many-to-one association to MShowtime
	@ManyToOne
	@JoinColumn(name="SHOWTIME_ID")
	private MShowtime MShowtime;

	//bi-directional many-to-one association to MTicket
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	private MTicket MTicket;

	public MUserticket() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReserveDate() {
		return this.reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
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