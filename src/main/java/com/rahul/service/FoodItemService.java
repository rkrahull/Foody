package com.rahul.service;

import com.rahul.entity.FoodItem;
import com.rahul.exception.InvalidIdException;
import com.rahul.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodItemService {

    @Autowired
    FoodItemRepository repository;

    public UUID save(FoodItem foodItem){
        foodItem.setCreateDate(LocalDate.now());
        FoodItem savedItem = repository.save(foodItem);
        return savedItem.getId();
    }

    public List<FoodItem> getAllFoodItems(){
        return repository.findAll();
    }

    public FoodItem updateFoodItem(FoodItem foodItem) throws InvalidIdException {
        FoodItem item = getFoodItemById(foodItem.getId());
        foodItem.setUpdateDate(LocalDate.now());
        repository.save(foodItem);
        return foodItem;
    }

    public FoodItem getFoodItemById(UUID id) throws InvalidIdException {
        Optional<FoodItem> foodItem = repository.findById(id);
        if(foodItem.isPresent())
            return foodItem.get();
        else
            throw new InvalidIdException("Invalid Id : " + id);
    }

    public void deleteFoodItem(FoodItem foodItem){
        repository.delete(foodItem);
    }


}
