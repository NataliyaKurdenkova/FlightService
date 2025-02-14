package com.gridnine.testing.service.impl;

import com.gridnine.testing.service.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService{
    @Override
    public void checkFilter(List<Flight> flights, List<Filter> filters) {
        for (Filter filter : filters) {
            System.out.println("Filter: " + filter.getClass().getSimpleName());

            filter.filter(flights)
                    .forEach(System.out::println);

            System.out.println("________________________");
        }
    }
}
