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
        pizzaService.testAddPizza("Гавайская", "Казань", "Хочу и буду", 350, 5, 400);
        pizzaService.testAddPizza("Пепперони", "Казань", "4 кухни", 400, 4, 450);
        pizzaService.testAddPizza("Пепперони", "Казань", "Хочу и буду", 390, 5, 350);

        model.addAttribute("pizza", pizzaService.getPizzaList());
        return "mainPage";
    }

    @GetMapping("/average")
    public String getAverage(Model model){
        model.addAttribute("average", pizzaService.calcAveragePrice("Казань", "Пепперони"));
        return "average";
    }


}