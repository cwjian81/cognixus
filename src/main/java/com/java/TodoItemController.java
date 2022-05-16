package com.java;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoItemController {
	@Autowired
    private TodoItemService todoItemService;
	
	// Retrieval operations
    @GetMapping("/todoItems")
    public List<TodoItem> list() {
    	// return list of student 
        return todoItemService.listAll();
    }
     
    // Create operation
    @PostMapping("/todoItems")
    public void add(@RequestBody TodoItem todoItem) {
    	// insert new student details to the list
    	todoItemService.save(todoItem);
    }
     
    // Update operation
    @PutMapping("/todoItems/{id}")
    public ResponseEntity<?> update(@RequestBody TodoItem todoItem, @PathVariable Integer id) {
        try {
        	// check is the id in DB, else catch error
        	TodoItem existTodoItem = todoItemService.get(id);
        	todoItemService.save(todoItem);
            
            //return http 200 status
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
        	
        	// return http 404 status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // Delete operation
    @DeleteMapping("/todoItems/{id}")
    public void delete(@PathVariable Integer id) {
    	todoItemService.delete(id);
    }
}
