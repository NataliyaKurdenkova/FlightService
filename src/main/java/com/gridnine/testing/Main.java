package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.filter.Filter;
import com.gridnine.testing.service.filter.impl.DepartsEarlierThanItArrivesFilter;
import com.gridnine.testing.service.filter.impl.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.service.filter.impl.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.service.impl.FlightServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("All Flight list:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("_____________________");


        List<Filter> filters = new ArrayList<>();
        filters.add(new DepartureBeforeCurrentTimeFilter());
        filters.add(new DepartsEarlierThanItArrivesFilter());
        filters.add(new GroundTimeExceedsTwoHoursFilter());

        var flightService = new FlightServiceImpl();
        flightService.checkFilter(flights, filters);
    }
}
