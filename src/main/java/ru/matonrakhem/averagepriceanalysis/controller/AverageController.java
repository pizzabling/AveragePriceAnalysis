package ru.matonrakhem.averagepriceanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.matonrakhem.averagepriceanalysis.service.PizzaService;

@Controller
public class AverageController {

    private final PizzaService pizzaService;

    public AverageController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        pizzaService.testAddPizza();
        model.addAttribute("pizza", pizzaService.getPizzaList());
        return "mainPage";
    }

    @GetMapping("/average")
    public String getAverage(Model model){
        model.addAttribute("average", pizzaService.calcAveragePrice("Казань", "Пепперони"));
        return "average";
    }


}