package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the M_ADMIN database table.
 * 
 */
@Entity
@Table(name="M_ADMIN",schema="TESTDB")
@NamedQuery(name="MAdmin.findAll", query="SELECT m FROM MAdmin m")
public class MAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	@Column(name="PROFILE_PICTURE")
	private String profilePicture;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to MCart
	@OneToMany(mappedBy="MAdmin")
	private List<MCart> MCarts;

	//bi-directional many-to-one association to MReview
	@OneToMany(mappedBy="MAdmin")
	private List<MReview> MReviews;

	//bi-directional many-to-one association to MUserticket
	@OneToMany(mappedBy="MAdmin")
	private List<MUserticket> MUsertickets;

	public MAdmin() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MCart> getMCarts() {
		return this.MCarts;
	}

	public void setMCarts(List<MCart> MCarts) {
		this.MCarts = MCarts;
	}

	public MCart addMCart(MCart MCart) {
		getMCarts().add(MCart);
		MCart.setMAdmin(this);

		return MCart;
	}

	public MCart removeMCart(MCart MCart) {
		getMCarts().remove(MCart);
		MCart.setMAdmin(null);

		return MCart;
	}

	public List<MReview> getMReviews() {
		return this.MReviews;
	}

	public void setMReviews(List<MReview> MReviews) {
		this.MReviews = MReviews;
	}

	public MReview addMReview(MReview MReview) {
		getMReviews().add(MReview);
		MReview.setMAdmin(this);

		return MReview;
	}

	public MReview removeMReview(MReview MReview) {
		getMReviews().remove(MReview);
		MReview.setMAdmin(null);

		return MReview;
	}

	public List<MUserticket> getMUsertickets() {
		return this.MUsertickets;
	}

	public void setMUsertickets(List<MUserticket> MUsertickets) {
		this.MUsertickets = MUsertickets;
	}

	public MUserticket addMUserticket(MUserticket MUserticket) {
		getMUsertickets().add(MUserticket);
		MUserticket.setMAdmin(this);

		return MUserticket;
	}

	public MUserticket removeMUserticket(MUserticket MUserticket) {
		getMUsertickets().remove(MUserticket);
		MUserticket.setMAdmin(null);

		return MUserticket;
	}

}