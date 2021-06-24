package com.springrest.MilkDistAPI.servicesInterface;

import com.springrest.MilkDistAPI.entities.Price;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public interface PriceService {

    void addPrice(Price price);

    void updatePrice(String id, Price price);

    List<Price> getAllPrice();
}
