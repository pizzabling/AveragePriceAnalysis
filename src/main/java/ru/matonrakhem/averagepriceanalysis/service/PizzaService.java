package ru.matonrakhem.averagepriceanalysis.service;

import org.springframework.stereotype.Service;
import ru.matonrakhem.averagepriceanalysis.model.PizzaModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    private List<PizzaModel> pizzaModelList = new ArrayList<>();

    public List<PizzaModel> getPizzaList(){
        return pizzaModelList;
    }

    public void savePizzaList(PizzaModel model){
        pizzaModelList.add(model);
    }

    public void calcAverage(){
        for (PizzaModel pizzaModel : pizzaModelList){

        }
    }
}
