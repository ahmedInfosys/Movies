package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_MOVIES database table.
 * 
 */
@Entity
@Table(name="M_MOVIES",schema="TESTDB")
@NamedQuery(name="MMovy.findAll", query="SELECT m FROM MMovy m")
public class MMovy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int availability;

	@Column(name="COVER_PICTURE")
	private String coverPicture;

	private String description;

	private String title;

	private String trailers;

	//bi-directional many-to-one association to MReview
	@OneToMany(mappedBy="MMovy")
	private List<MReview> MReviews;

	//bi-directional many-to-one association to MShowtime
	@OneToMany(mappedBy="MMovy")
	private List<MShowtime> MShowtimes;

	//bi-directional many-to-one association to MTicket
	@OneToMany(mappedBy="MMovy")
	private List<MTicket> MTickets;

	public MMovy() {
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

	public String getCoverPicture() {
		return this.coverPicture;
	}

	public void setCoverPicture(String coverPicture) {
		this.coverPicture = coverPicture;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrailers() {
		return this.trailers;
	}

	public void setTrailers(String trailers) {
		this.trailers = trailers;
	}

	public List<MReview> getMReviews() {
		return this.MReviews;
	}

	public void setMReviews(List<MReview> MReviews) {
		this.MReviews = MReviews;
	}

	public MReview addMReview(MReview MReview) {
		getMReviews().add(MReview);
		MReview.setMMovy(this);

		return MReview;
	}

	public MReview removeMReview(MReview MReview) {
		getMReviews().remove(MReview);
		MReview.setMMovy(null);

		return MReview;
	}

	public List<MShowtime> getMShowtimes() {
		return this.MShowtimes;
	}

	public void setMShowtimes(List<MShowtime> MShowtimes) {
		this.MShowtimes = MShowtimes;
	}

	public MShowtime addMShowtime(MShowtime MShowtime) {
		getMShowtimes().add(MShowtime);
		MShowtime.setMMovy(this);

		return MShowtime;
	}

	public MShowtime removeMShowtime(MShowtime MShowtime) {
		getMShowtimes().remove(MShowtime);
		MShowtime.setMMovy(null);

		return MShowtime;
	}

	public List<MTicket> getMTickets() {
		return this.MTickets;
	}

	public void setMTickets(List<MTicket> MTickets) {
		this.MTickets = MTickets;
	}

	public MTicket addMTicket(MTicket MTicket) {
		getMTickets().add(MTicket);
		MTicket.setMMovy(this);

		return MTicket;
	}

	public MTicket removeMTicket(MTicket MTicket) {
		getMTickets().remove(MTicket);
		MTicket.setMMovy(null);

		return MTicket;
	}

}