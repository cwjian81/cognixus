package com.java;

import javax.persistence.*;

@Entity
public class TodoItem {
	private Integer id;
	private String todo_item;
	private boolean is_complete;
	

	public TodoItem() {
		
	}
	
	public TodoItem(Integer id, String todo_item, boolean is_complete) {
		this.id= id;
		this.todo_item = todo_item;
		this.is_complete = is_complete;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTodo_item() {
		return todo_item;
	}
	public void setTodo_item(String todo_item) {
		this.todo_item = todo_item;
	}
	public boolean isIs_complete() {
		return is_complete;
	}
	public void setIs_complete(boolean is_complete) {
		this.is_complete = is_complete;
	}

}
