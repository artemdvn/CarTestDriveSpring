package cartestdrive.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cartestdrive.domain.Car;
import cartestdrive.domain.Showroom;
import cartestdrive.service.CarTestDriveService;

@Controller
public class CarTestDriveController {
	
	@Autowired
	private CarTestDriveService carTestDriveService;
	
	@RequestMapping("/main")
	public ModelAndView mainFrame(Map<String, Object> map) {
		map.put("showrooms", carTestDriveService.getShowrooms());
        map.put("carList", carTestDriveService.getAllCars());
        map.put("showroomSelectedId", 0);
        return new ModelAndView("MainFrame", "form", map);
	}
	
	@RequestMapping("/index")
    public String startPage() {
        return "index";
    }
	
	@RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
	
	@RequestMapping("/showrooms")
	public ModelAndView showroomList() {
		return new ModelAndView("ShowroomList", "showroomList", carTestDriveService.getShowrooms());
	}
	
	
	@RequestMapping("getAllCars")
    public ModelAndView getAllCars(@RequestParam int showroomSelectedId, Map<String, Object> map) {
		Showroom s = carTestDriveService.getShowroomById(showroomSelectedId);
		List<Car> cars = carTestDriveService.getCarsFromShowroom(s);
		map.put("showrooms", carTestDriveService.getShowrooms());
        map.put("carList", cars);
        map.put("showroomSelectedId", showroomSelectedId);
        return new ModelAndView("MainFrame", "form", map);
    }
	
	@RequestMapping("getOnlyFreeCars")
    public ModelAndView getOnlyFreeCars(@RequestParam int showroomSelectedId, Map<String, Object> map) {
		Showroom s = carTestDriveService.getShowroomById(showroomSelectedId);
		List<Car> cars = carTestDriveService.getFreeCarsFromShowroom(s);
		map.put("showrooms", carTestDriveService.getShowrooms());
        map.put("carList", cars);
        map.put("showroomSelectedId", showroomSelectedId);
        return new ModelAndView("MainFrame", "form", map);
    }
	
	@RequestMapping("moveCarsToShowroom")
    public ModelAndView moveCarsToShowroom(@RequestParam int showroomSelectedId, Map<String, Object> map) {
		Showroom s = carTestDriveService.getShowroomById(showroomSelectedId);
		carTestDriveService.moveCarsToShowroom(s);
		map.put("showrooms", carTestDriveService.getShowrooms());
        map.put("carList", carTestDriveService.getCarsFromShowroom(s));
        map.put("showroomSelectedId", showroomSelectedId);
        return new ModelAndView("MainFrame", "form", map);
    }
	
	@RequestMapping("addShowroom")
	public ModelAndView addShowroom(@ModelAttribute Showroom s) {
		return new ModelAndView("ShowroomFrame");
	}
	
	@RequestMapping("saveShowroom")
    public ModelAndView saveEmployee(@ModelAttribute Showroom showroom) {
        if(showroom.getShowroomId() == 0){
        	carTestDriveService.insertShowroom(showroom);
        } else {
        	carTestDriveService.updateShowroom(showroom);
        }
        return new ModelAndView("redirect:/showrooms");
    }
	
	@RequestMapping("editShowroom")
    public ModelAndView editEmployee(@RequestParam int id, @ModelAttribute Showroom showroom) {
		showroom = carTestDriveService.getShowroomById(id);
        return new ModelAndView("ShowroomFrame", "showroomObject", showroom);
    }
	
	@RequestMapping("deleteShowroom")
	public ModelAndView deleteShowroom(@RequestParam int id) {
		Showroom showroom = carTestDriveService.getShowroomById(id);
		carTestDriveService.deleteShowroom(showroom);
		return new ModelAndView("redirect:/showrooms");
	}
	
	@RequestMapping("addCar")
	public ModelAndView addCar(@ModelAttribute Car car) {
		List<Showroom> showrooms = carTestDriveService.getShowrooms();
		return new ModelAndView("CarFrame", "showrooms", showrooms);
	}
	
	@RequestMapping("saveCar")
    public ModelAndView saveCar(@ModelAttribute Car car) {
        if(car.getCarId() == 0){
        	carTestDriveService.insertCar(car);
        } else {
        	carTestDriveService.updateCar(car);
        }
        return new ModelAndView("redirect:/main");
    }
	
	@RequestMapping("editCar")
    public ModelAndView editCar(@RequestParam int id, @ModelAttribute Car car, Map<String, Object> map) {
		car = carTestDriveService.getCarById(id);
		map.put("showrooms", carTestDriveService.getShowrooms());
        map.put("carObject", car);
        return new ModelAndView("CarFrame", "form", map);
    }
	
	@RequestMapping("deleteCar")
	public ModelAndView deleteCar(@RequestParam int id) {
		Car car = carTestDriveService.getCarById(id);
		carTestDriveService.deleteCar(car);
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping("reserveCar")
	public ModelAndView reserveCar(@RequestParam int id) {
		Car car = carTestDriveService.getCarById(id);
		car.setReserved(true);
		carTestDriveService.updateCar(car);
		return new ModelAndView("redirect:/main");
	}
	
	@RequestMapping("releaseCar")
	public ModelAndView releaseCar(@RequestParam int id) {
		Car car = carTestDriveService.getCarById(id);
		car.setReserved(false);
		carTestDriveService.updateCar(car);
		return new ModelAndView("redirect:/main");
	}
	
}
