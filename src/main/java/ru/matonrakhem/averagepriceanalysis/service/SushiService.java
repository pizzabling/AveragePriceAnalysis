package ru.matonrakhem.averagepriceanalysis.service;

import org.springframework.stereotype.Service;
import ru.matonrakhem.averagepriceanalysis.model.SushiModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class SushiService {
    private List<SushiModel> sushiModelList = new ArrayList<>();
    private List<SushiModel> tempSushiModel = new ArrayList<>();
    private long id = 0;

    /*Берём список суши*/
    public List<SushiModel> getSushiList() {
        return sushiModelList;
    }

    /*Сейвим суши*/
    public void saveSushiList(SushiModel model) {
        model.setId(id);
        sushiModelList.add(model);
        id++;
    }

    /*Считаем средний ценник по суши. Фильтр: город, название суши*/
    public double calcAverageSushiPrice(String city, String sushiName) {
        tempSushiModel.clear();
        double tempPrice;
        double sumPrice = 0;
        double avgPrice;
        int count = 0;
        /*Объявляем новый список с ценниками суши*/
        List<Double> allPriceSushi = new ArrayList<>();

        /*Вытаскиваем суши, которые подходят под условия фильтра*/
        for (SushiModel sushiModel : sushiModelList) {
            if (sushiModel.getSushiName().equals(sushiName) && sushiModel.getCity().equals(city)) {
                tempSushiModel.add(sushiModel);
            }
        }

        /*Вытаскиваем все ценники суши, которые попали под условия фильтра*/
        for (SushiModel temprarySushiModel : tempSushiModel) {
            allPriceSushi.add(temprarySushiModel.getPrice());
        }
        /*Рассчитываем сумму пицц, которые попали под условия фильтра */
        for (int i = 0; i < allPriceSushi.size(); i++) {
            count++;
            tempPrice = allPriceSushi.get(i);
            sumPrice = tempPrice + sumPrice;
        }
        /*Считаем средний ценник суши, которые попали под условия фильтра*/
        avgPrice = sumPrice / count;

        /*Возвращаем средний ценник*/
        return avgPrice;
    }

    /*Вытаскиваем все пиццы по фильтру: Город, название суши*/
    public List<SushiModel> getSushiByCityAndSushiName(String city, String name) {
        tempSushiModel.clear();
        /*Вытаскиваем суши, которые подходят под условия фильтра*/
        for (SushiModel sushiModel : sushiModelList) {
            if (sushiModel.getSushiName().equals(name) && sushiModel.getCity().equals(city)) {
                tempSushiModel.add(sushiModel);
            }
        }
        return tempSushiModel;
    }

    public void testAddSushi(String sushiName, String city, String restName, double price, double rating, double weight) {
        SushiModel model = new SushiModel();
        model.setSushiName(sushiName);
        model.setCity(city);
        model.setPrice(price);
        model.setRating(rating);
        model.setWeight(weight);
        model.setRestaurantName(restName);

        saveSushiList(model);
    }

    public List<SushiModel> getSushiByRestaurantAndSushiName(String restaurant, String name) {
        tempSushiModel.clear();
        /*Вытаскиваем суши, которые подходят под условия фильтра*/
        for (SushiModel sushiModel : sushiModelList) {
            if (sushiModel.getSushiName().equals(name) && sushiModel.getCity().equals(restaurant)) {
                tempSushiModel.add(sushiModel);
            }
        }
        return tempSushiModel;
    }
}

