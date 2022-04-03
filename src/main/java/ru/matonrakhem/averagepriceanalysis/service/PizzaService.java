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
    private double avgPrice;

    /*Берём список пицц*/
    public List<PizzaModel> getPizzaList(){
        return pizzaModelList;
    }

    /*Сейвим пиццу*/
    public void savePizzaList(PizzaModel model){
        model.setId(id);
        pizzaModelList.add(model);
        id++;
    }

    public double getAvgPrice(){
        return avgPrice;
    }

    /*Считаем средний ценник по пиццам. Фильтр: город, название пиццы*/
    public void calcAveragePrice(String city, String pizzaName){
        tempPizzaModel.clear();
        double tempPrice;
        double sumPrice = 0;

        int count = 0;
        /*Объявляем новый список с ценниками пицц*/
        List<Double> allPricePizza = new ArrayList<>();

        /*Вытаскиваем пиццы, которые подходят под условия фильтра*/
        for (PizzaModel pizzaModel : pizzaModelList){
            if(pizzaModel.getPizzaName().equals(pizzaName) && pizzaModel.getCity().equals(city)){
                tempPizzaModel.add(pizzaModel);
            }
        }

        /*Вытаскиваем все ценники пицц, которые попали под условия фильтра*/
        for (PizzaModel tempraryPizzaModel : tempPizzaModel){
            allPricePizza.add(tempraryPizzaModel.getPrice());
        }
        /*Рассчитываем сумму пицц, которые попали под условия фильтра */
        for(int i = 0; i < allPricePizza.size(); i++){
            count++;
            tempPrice = allPricePizza.get(i);
            sumPrice = tempPrice + sumPrice;
        }
        /*Считаем средний ценник пицц, которые попали под условия фильтра*/
        avgPrice = sumPrice / count;
    }

    /*Вытаскиваем все пиццы по фильтру: Город, название пиццы*/
    public List<PizzaModel> getPizzaByCityAndPizzaName(String city, String name){
        tempPizzaModel.clear();
        /*Вытаскиваем пиццы, которые подходят под условия фильтра*/
        for (PizzaModel pizzaModel : pizzaModelList){
            if(pizzaModel.getPizzaName().equals(name) && pizzaModel.getCity().equals(city)){
                tempPizzaModel.add(pizzaModel);
            }
        }
        return tempPizzaModel;
    }

    public void testAddPizza(String pizzaName, String city, String restName, double price, double rating, double weight){
        PizzaModel model = new PizzaModel();
        model.setPizzaName(pizzaName);
        model.setCity(city);
        model.setPrice(price);
        model.setRating(rating);
        model.setWeight(weight);
        model.setRestaurantName(restName);

        savePizzaList(model);
    }
}
