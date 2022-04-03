package ru.matonrakhem.averagepriceanalysis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SushiModel {
    private long id;
    private double price;
    private double weight;
    private double rating;
    private String sushiName;
    private String restaurantName;
    private String city;
}

