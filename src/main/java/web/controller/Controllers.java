package web.controller;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.ServiceCarImp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class Controllers {
	ServiceCarImp carImp = new ServiceCarImp();

	@GetMapping(value = "msg")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello from Kensyn!");
		messages.add("I'm just change this Application");
		messages.add("and now 21.11.2021");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "cars")
	public String printCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, ModelMap modelCar) {
		modelCar.addAttribute("cars", carImp.getCars(count));
		return "cars";
	}
}