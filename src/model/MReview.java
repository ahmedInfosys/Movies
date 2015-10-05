package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the M_REVIEWS database table.
 * 
 */
@Entity
@Table(name="M_REVIEWS",schema="TESTDB")
@NamedQuery(name="MReview.findAll", query="SELECT m FROM MReview m")
public class MReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="R_DATE")
	private String rDate;

	private int ratingscale;

	private String review;

	//bi-directional many-to-one association to MAdmin
	@ManyToOne
	@JoinColumn(name="ADMIN_ID")
	private MAdmin MAdmin;

	//bi-directional many-to-one association to MMovy
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private MMovy MMovy;

	public MReview() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRDate() {
		return this.rDate;
	}

	public void setRDate(String rDate) {
		this.rDate = rDate;
	}

	public int getRatingscale() {
		return this.ratingscale;
	}

	public void setRatingscale(int ratingscale) {
		this.ratingscale = ratingscale;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public MAdmin getMAdmin() {
		return this.MAdmin;
	}

	public void setMAdmin(MAdmin MAdmin) {
		this.MAdmin = MAdmin;
	}

	public MMovy getMMovy() {
		return this.MMovy;
	}

	public void setMMovy(MMovy MMovy) {
		this.MMovy = MMovy;
	}

}