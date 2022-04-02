package ru.matonrakhem.averagepriceanalysis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PizzaModel {
    private long id;
    private double price;
    private double weight;
    private double rating;
    private String pizzaName;
    private String restaurantName;
    private String city;
}
