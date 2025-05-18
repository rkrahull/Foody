package com.rahul.controller;

import com.rahul.entity.FoodItem;
import com.rahul.exception.InvalidIdException;
import com.rahul.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food-item")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/add")
    ResponseEntity<UUID> addFoodItem(@Valid @RequestBody FoodItem foodItem){
        UUID id = foodItemService.save(foodItem);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<FoodItem>> getAllFoodItems(){
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    @GetMapping("/get/{id}")
    ResponseEntity<FoodItem> getFoodItemById(@PathVariable UUID id) throws InvalidIdException {
            FoodItem foodItem = foodItemService.getFoodItemById(id);
            return new ResponseEntity<>(foodItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.deleteFoodItem(foodItem);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    ResponseEntity<FoodItem> updateFoodItem(@Valid @RequestBody FoodItem foodItem) throws InvalidIdException {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(foodItem);
        return new ResponseEntity<>(updatedFoodItem, HttpStatus.OK);
    }



}
