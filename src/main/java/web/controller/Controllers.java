
package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceCarImp;

import java.util.ArrayList;
import java.util.List;
@Controller
public class Controllers {

	@Autowired
	private ServiceCarImp carImp;

	@GetMapping(value = "msg")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello from Kensyn!");
		messages.add("I'm just change this Application");
		messages.add("and now 21.11.2021");
		model.addAttribute("messages", messages);
		return "index";
	}

//	@GetMapping(value = "cars")
//	public String printCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, ModelMap modelCar) {
//		modelCar.addAttribute("cars", carImp.getCars(count));
//		return "mech";
//	}
	@GetMapping(value = "cars")
	public String printCars(@RequestParam(name = "count", required = false) Integer count, ModelMap modelMap) {
		if (count != null) {
			modelMap.addAttribute("cars", carImp.getCars(count));
		} else {
			modelMap.addAttribute("cars", carImp.allCars());
		}
		return "mech";
	}
}