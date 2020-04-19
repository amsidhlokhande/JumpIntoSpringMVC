package com.amsidh.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amsidh.domain.Airport;
import com.amsidh.domain.Flight;
import com.amsidh.domain.FlightLeg;
import com.amsidh.domain.FlightSearchCriteria;
import com.amsidh.domain.SpecialDeal;

public class FlightServiceImpl implements FlightService {
    
    private static final long TWO_HOURS = 1000*60*60*2;

    public List<SpecialDeal> getSpecialDeals() {
        // in reality, pull from a database via a DAO
        List<SpecialDeal> specials = new ArrayList<SpecialDeal>();
        specials.add(new SpecialDeal(new Airport("Baltimore", "BWI"),
                new Airport("New York City", "LGA"), new BigDecimal(250),
                new Date(), new Date()));
        specials.add(new SpecialDeal(new Airport("Honolulu", "HNL"),
                new Airport("Orlando", "MCO"), new BigDecimal(500),
                new Date(), new Date()));
        specials.add(new SpecialDeal(new Airport("Tokyo", "NRT"),
                new Airport("San Francisco", "SFO"), new BigDecimal(700),
                new Date(), new Date()));
        return specials;
    }

    public List<Flight> findFlights(FlightSearchCriteria search) {
        // in reality, pull from a database via a DAO
        List<Flight> flights = new ArrayList<Flight>();
        
        List<FlightLeg> legs = new ArrayList<FlightLeg>();
        legs.add(new FlightLeg(
                new Airport(search.getDepartFrom(), "ABC"),
                search.getDepartOn(),
                new Airport(search.getArriveAt(), "XYZ"),
                new Date(search.getDepartOn().getTime()+TWO_HOURS)));
        
        flights.add(new Flight(legs, new BigDecimal(500)));
        
        return flights;
    }

}
