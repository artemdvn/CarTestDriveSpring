package cartestdrive.dao;

import java.util.List;

import cartestdrive.domain.Car;
import cartestdrive.domain.Showroom;

public interface CarTestDriveDAO {

	public void insertCar(Car car);

	public void updateCar(Car car);

	public void deleteCar(Car car);
	
	public Car getCarById(int carId);
	
	public List<Car> getAllCars();

	public List<Car> getCarsFromShowroom(Showroom showroom);

	public List<Car> getFreeCarsFromShowroom(Showroom showroom);

	public void moveCarsToShowroom(Showroom newShowroom);

	public void removeCarsFromShowroom(Showroom showroom);
	
	public void insertShowroom(Showroom s);

    public void updateShowroom(Showroom s);
    
    public void deleteShowroom(Showroom s);
	
	public List<Showroom> getShowrooms();

    public Showroom getShowroomById(int showroomId);    

}