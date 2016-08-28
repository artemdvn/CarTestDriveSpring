package cartestdrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cartestdrive.dao.CarTestDriveDAO;
import cartestdrive.domain.Car;
import cartestdrive.domain.Showroom;

@Service
public class CarTestDriveServiceImpl implements CarTestDriveService {

    @Autowired
    private CarTestDriveDAO carTestDriveDAO;
    
    private CarTestDriveServiceImpl() {
    }

    @Transactional
    public List<Showroom> getShowrooms() {
    	return carTestDriveDAO.getShowrooms();		
    }

    @Transactional
    public List<Car> getAllCars() {
    	return carTestDriveDAO.getAllCars();		
    }

    @Transactional
    public List<Car> getCarsFromShowroom(Showroom showroom){
    	return carTestDriveDAO.getCarsFromShowroom(showroom);        
    }
    
    @Transactional
    public List<Car> getFreeCarsFromShowroom(Showroom showroom){
    	return carTestDriveDAO.getFreeCarsFromShowroom(showroom);    
    }
    
    @Transactional
    public Car getCarById(int carId) {
    	return carTestDriveDAO.getCarById(carId);
    }
    
    @Transactional
    public Showroom getShowroomById(int showroomId) {    	
    	return carTestDriveDAO.getShowroomById(showroomId);
	}

    @Transactional
    public void moveCarsToShowroom(Showroom newShowroom) {
		carTestDriveDAO.moveCarsToShowroom(newShowroom);
	}

    @Transactional
    public void removeCarsFromShowroom(Showroom showroom) {
		carTestDriveDAO.removeCarsFromShowroom(showroom);
	}

    @Transactional
    public void insertCar(Car car) {
    	carTestDriveDAO.insertCar(car);
    }

    @Transactional
    public void updateCar(Car car) {
    	carTestDriveDAO.updateCar(car);
    }

    @Transactional
    public void deleteCar(Car car) {
    	carTestDriveDAO.deleteCar(car);
    }
    
    @Transactional
    public void insertShowroom(Showroom s) {
    	carTestDriveDAO.insertShowroom(s);
	}

    @Transactional
    public void updateShowroom(Showroom s) {
		carTestDriveDAO.updateShowroom(s);
    }
    
    @Transactional
    public void deleteShowroom(Showroom s) {
		carTestDriveDAO.deleteShowroom(s);
    }
}