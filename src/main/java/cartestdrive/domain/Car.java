package cartestdrive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_id", unique = true, nullable = false)
	private int carId;
	
	@Column(name = "carName", nullable = false)
	private String carName;
	
	@Column(name = "modelName", nullable = false)
	private String modelName;
	
	@Column(name = "yearOfIssue", nullable = false)
	private int yearOfIssue;
	
	@Column(name = "showroom_id", nullable = false)
	private int showroomId;
	
	@Column(name = "mileage", nullable = false)
	private int mileage;
	
	@Column(name = "reserved", nullable = false)
	private boolean reserved;

	public Car() {
	}
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getYearOfIssue() {
		return yearOfIssue;
	}

	public void setYearOfIssue(int yearOfIssue) {
		this.yearOfIssue = yearOfIssue;
	}

	public int getShowroomId() {
		return showroomId;
	}

	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", modelName=" + modelName + ", yearOfIssue=" + yearOfIssue + ", mileage="
				+ mileage + "]";
	}
}
