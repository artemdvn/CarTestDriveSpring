package cartestdrive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "showrooms")
public class Showroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "showroom_id", unique = true, nullable = false)
	private int showroomId;
	
	@Column(name = "nameShowroom", nullable = false)
	private String nameShowroom;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	public Showroom() {
	}
	
	public Showroom(int id, String name, String address) {
		this.showroomId = id;
		this.nameShowroom = name;
		this.address = address;		
	}
	
	public int getShowroomId() {
		return showroomId;
	}

	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}
	
	public String getNameShowroom() {
		return nameShowroom;
	}

	public void setNameShowroom(String nameShowroom) {
		this.nameShowroom = nameShowroom;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Showroom [nameShowroom=" + nameShowroom + "]";
	}

}
