package ru.matonrakhem.averagepriceanalysis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantModel {

    private long id;
    private double raiting;
    private String city;
    private String name;
    private String website;
}
