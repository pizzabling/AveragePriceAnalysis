package ru.matonrakhem.averagepriceanalysis.service;

import org.springframework.stereotype.Service;
import ru.matonrakhem.averagepriceanalysis.model.PizzaModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    private List<PizzaModel> pizzaModelList = new ArrayList<>();
    private List<PizzaModel> tempPizzaModel = new ArrayList<>();
    private long id = 0;
    public List<PizzaModel> getPizzaList(){
        return pizzaModelList;
    }

    public void savePizzaList(PizzaModel model){
        model.setId(id);
        pizzaModelList.add(model);
        id++;
    }

    public void calcAverage(String city, String pizzaName){
        double tempPrice;
        double sumPrice = 0;
        double avgPrice;
        int i;
        List<Double> allPricePizza = new ArrayList<>();
        for (PizzaModel pizzaModel : pizzaModelList){
            if(pizzaModel.getPizzaName().equals(pizzaName) && pizzaModel.getCity().equals(city)){
                tempPizzaModel.add(pizzaModel);
            }
        }
        for (PizzaModel tempraryPizzaModel : tempPizzaModel){
            allPricePizza.add(tempraryPizzaModel.getPrice());
        }

        for(i = 0; i <= allPricePizza.size(); i++){
            tempPrice = allPricePizza.get(i);
            sumPrice = tempPrice + sumPrice;
        }

        avgPrice = sumPrice / i;

    }
}
