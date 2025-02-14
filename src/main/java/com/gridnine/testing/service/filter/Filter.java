package com.gridnine.testing.service.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface Filter {

    List<Flight> filter(List<Flight> flights);
}
