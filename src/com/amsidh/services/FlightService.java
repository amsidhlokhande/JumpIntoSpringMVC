package com.amsidh.services;

import java.util.List;

import com.amsidh.domain.Flight;
import com.amsidh.domain.FlightSearchCriteria;
import com.amsidh.domain.SpecialDeal;

public interface FlightService {

    List<SpecialDeal> getSpecialDeals();
   
    List<Flight> findFlights(FlightSearchCriteria search);
   
}
