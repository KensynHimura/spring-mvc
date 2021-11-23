package web.controller;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {
	List<Car> cars = new ArrayList<>();

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
		cars.clear();
		cars.add(new Car("red", true, 4));
		cars.add(new Car("white", false, 16));
		cars.add(new Car("black", false, 4));
		cars.add(new Car("red", false, 3));
		cars.add(new Car("green", true, 4));
		if (count <= 5) {
			modelCar.addAttribute("cars", getCars(count));
		} else {
			modelCar.addAttribute("cars", cars);
		}
		return "cars";
	}

	public List<Car> getCars(int value) {
		return cars.stream().filter(f -> value > 0 && value <= 5).limit(value).collect(Collectors.toList()) ;
	}
}