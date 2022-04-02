package ru.matonrakhem.averagepriceanalysis.service;

import org.springframework.stereotype.Service;
import ru.matonrakhem.averagepriceanalysis.model.RestaurantModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private long id = 0;
    private List<RestaurantModel> restaurantModelList = new ArrayList<>();
    private List<RestaurantModel> tempRestaurantModelList = new ArrayList<>();

    public List<RestaurantModel> getRestaurantModelList() {
        return restaurantModelList;
    }

    public void saveRestaurantList(RestaurantModel model) {
        model.setId(id);
        restaurantModelList.add(model);
        id++;
    }

    public double calcAverageRaiting(String city) {
        double tempRaiting;
        double sumRaiting = 0;
        double avgRaiting;
        int count = 0;
        List<Double> allRaitingRestaurant = new ArrayList<>();

        for (RestaurantModel restaurantModel : restaurantModelList) {
            if (restaurantModel.getCity().equals(city)) {
                tempRestaurantModelList.add(restaurantModel);
            }
        }
        for (RestaurantModel temporaryRestourantModel : tempRestaurantModelList) {
            allRaitingRestaurant.add(temporaryRestourantModel.getRaiting());
        }
        for (int i = 0; i <= allRaitingRestaurant.size(); i++) {
            count++;
            tempRaiting = allRaitingRestaurant.get(i);
            sumRaiting = tempRaiting + sumRaiting;
        }
        avgRaiting = sumRaiting / count;

        return avgRaiting;
    }
}

