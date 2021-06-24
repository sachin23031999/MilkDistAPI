package com.springrest.MilkDistAPI.servicesImpl;

import com.springrest.MilkDistAPI.Dao.PriceDao;
import com.springrest.MilkDistAPI.entities.Price;
import com.springrest.MilkDistAPI.servicesInterface.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService
{
    @Autowired
    private PriceDao priceDao;

    public PriceServiceImpl() {

    }

    @Override
    public void addPrice(Price price) {
        priceDao.save(price);
    }

    @Override
    public void updatePrice(String id, Price price) {
        price.setId(Long.parseLong(id));
        priceDao.save(price);
    }

    @Override
    public List<Price> getAllPrice() {
        return priceDao.findAll();
    }
}
