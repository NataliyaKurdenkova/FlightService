package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.filter.Filter;

import java.util.List;

public interface FlightService {
    void checkFilter(List<Flight> flights, List<Filter> filters);
}
