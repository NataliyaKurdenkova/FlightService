package com.gridnine.testing.service.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.filter.Filter;

import java.util.List;
import java.util.stream.Collectors;

//Рейс, который отправляется раньше, чем прибывает (имеются сегменты с датой прилёта раньше даты вылета)
public class DepartsEarlierThanItArrivesFilter implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {

        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
