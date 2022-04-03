package ru.matonrakhem.averagepriceanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.matonrakhem.averagepriceanalysis.service.PizzaService;
import ru.matonrakhem.averagepriceanalysis.service.SushiService;

@Controller
public class AverageController {

    private final SushiService sushiService;
    private final PizzaService pizzaService;

    public AverageController(SushiService sushiService, PizzaService pizzaService) {
        this.sushiService = sushiService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/")
    public String mainPage(Model model){


        model.addAttribute("pizza", pizzaService.getPizzaList());
        return "mainPage";
    }
    @GetMapping("/sushi")
    public String sushiPage(Model model){


        return "sushi";
    }
    @GetMapping("/foodadd")

    public String foodadd (){
        sushiService.testAddSushi("Калифорния", "Казань", "Япончик", 150, 2, 200);
        sushiService.testAddSushi("Калифорния", "Казань", "Якитория", 250, 4, 190);
        sushiService.testAddSushi("Калифорния", "Москва", "Аппетит", 350, 3, 200);
        sushiService.testAddSushi("Суши с угрём", "Казань", "Якитория", 250, 5, 150);
        sushiService.testAddSushi("Суши с угрём", "Москва", "Аппетит", 350, 4, 130);
        sushiService.testAddSushi("Суши с угрём", "Казань", "Япончик", 250, 3, 150);
        pizzaService.testAddPizza("Гавайская", "Казань", "Хочу и буду", 350, 5, 400);
        pizzaService.testAddPizza("Пепперони", "Казань", "4 кухни", 400, 4, 450);
        pizzaService.testAddPizza("Пепперони", "Казань", "Хочу и буду", 390, 5, 350);
        pizzaService.testAddPizza("4 сыра", "Москва", "Джипси", 5000, 3, 350);
        pizzaService.testAddPizza("Пепперони", "Москва", "Джипси", 3000, 3, 350);
        return "foodadd";
    }


    @GetMapping("/average")
    public String getAverage(Model model){
        /*model.addAttribute("average", pizzaService.calcAveragePrice("Казань", "Пепперони"));*/
        model.addAttribute("filterByCityAndName",
                pizzaService.getPizzaByCityAndPizzaName("Казань", "Пепперони"));
        return "average";
    }
    @PostMapping("/average")
    public String setAttribute(@RequestParam String city, @RequestParam String pizzaName){
        pizzaService.calcAveragePrice("Казань", "Пепперони");
        return "average";
    }


}