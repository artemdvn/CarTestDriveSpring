package cartestdrive.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cartestdrive.domain.Car;
import cartestdrive.domain.Showroom;

@Repository
public class CarTestDriveDAOImpl implements CarTestDriveDAO {

    @Autowired
    private SessionFactory sf;
    
    private CarTestDriveDAOImpl() {
    }
    
    @SuppressWarnings("unchecked")
	public List<Showroom> getShowrooms() {
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Showroom");
        List<Showroom> showrooms = (List<Showroom>) query.list();		
		return showrooms;		
    }

    @SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Car ORDER BY carName, modelName, mileage");
		List<Car> cars = (List<Car>) query.list();		
		return cars;		
    }

    @SuppressWarnings("unchecked")
	public List<Car> getCarsFromShowroom(Showroom showroom){
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Car WHERE showroomId=:showroomId "
    			+ "ORDER BY carName, modelName, mileage");
    	query.setInteger("showroomId", showroom.getShowroomId());
    	List<Car> cars = (List<Car>) query.list();
		return cars;        
    }
    
    @SuppressWarnings("unchecked")
	public List<Car> getFreeCarsFromShowroom(Showroom showroom){
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Car "
    			+ "WHERE showroomId=:showroomId AND reserved=:reserved "
    			+ "ORDER BY carName, modelName, mileage");
    	query.setInteger("showroomId", showroom.getShowroomId());
    	query.setBoolean("reserved", false);
    	List<Car> cars = (List<Car>) query.list();
		return cars;    
    }
    
    public Car getCarById(int carId) {
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Car WHERE carId=:carId");
    	query.setInteger("carId", carId);
		Car car = (Car)query.uniqueResult();
		return car;
    }
    
    public Showroom getShowroomById(int showroomId) {    	
    	Session session = sf.getCurrentSession();
    	Query query = session.createQuery("from Showroom where showroomId = :showroomId");
    	query.setInteger("showroomId", showroomId);
        Showroom s = (Showroom) query.uniqueResult();        
		return s;
	}

    public void moveCarsToShowroom(Showroom newShowroom) {
		Session session = sf.getCurrentSession();
    	Query query = session.createQuery("UPDATE Car SET showroomId = :newId");
    	query.setInteger("newId", newShowroom.getShowroomId());
    	query.executeUpdate(); 
    }

    public void removeCarsFromShowroom(Showroom showroom) {
		Session session = sf.getCurrentSession();
    	Query query = session.createQuery("DELETE FROM Car WHERE showroomId = :showroomId");
    	query.setInteger("showroomId", showroom.getShowroomId());
    	query.executeUpdate(); 
    }

    public void insertCar(Car car) {
    	Session session = sf.getCurrentSession();
    	session.save(car);
    }

    public void updateCar(Car car) {
    	Session session = sf.getCurrentSession();
    	session.saveOrUpdate(car);
    }

    public void deleteCar(Car car) {
    	Session session = sf.getCurrentSession();
    	session.delete(car);
    }
    
    public void insertShowroom(Showroom s) {
		Session session = sf.getCurrentSession();
    	session.save(s);
    }

    public void updateShowroom(Showroom s) {
		Session session = sf.getCurrentSession();
    	session.saveOrUpdate(s);
    }
    
    public void deleteShowroom(Showroom s) {
		Session session = sf.getCurrentSession();
    	session.delete(s);
    }
}