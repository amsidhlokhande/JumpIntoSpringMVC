package com.amsidh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.amsidh.domain.FlightSearchCriteria;
import com.amsidh.services.FlightService;

public class SearchFlightsController extends SimpleFormController {

    private FlightService flightService;
    
    public SearchFlightsController() {
        setCommandName("flightSearchCriteria");
        setCommandClass(FlightSearchCriteria.class);
        setFormView("beginSearch");
        setSuccessView("listFlights");
    }

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH"), true));
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        FlightSearchCriteria search = (FlightSearchCriteria) command;
        ModelAndView mav = new ModelAndView(getSuccessView());
        mav.addObject("flights", flightService.findFlights(search));
        mav.addObject("flightSearchCriteria", search);
        return mav;
    }
    
}
