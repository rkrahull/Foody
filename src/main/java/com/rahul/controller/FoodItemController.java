package com.rahul.controller;

import com.rahul.entity.FoodItem;
import com.rahul.exception.InvalidIdException;
import com.rahul.service.FoodItemService;
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
    ResponseEntity<UUID> addFoodItem(@RequestBody FoodItem foodItem){
        UUID id = foodItemService.save(foodItem);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<FoodItem>> getAllFoodItems(){
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    @GetMapping("/get/{id}")
    ResponseEntity getFoodItemById(@PathVariable UUID id){
        try{
            FoodItem foodItem = foodItemService.getFoodItemById(id);
            return new ResponseEntity<>(foodItem, HttpStatus.OK);
        } catch (InvalidIdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.deleteFoodItem(foodItem);
        return ResponseEntity.ok().build();
    }



}
