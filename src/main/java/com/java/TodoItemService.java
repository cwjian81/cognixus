package com.java;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TodoItemService {
	@Autowired
	private TodoItemRepository tosoItemRepository;

	public List<TodoItem> listAll() {
		return tosoItemRepository.findAll();
	}

	public void save(TodoItem student) {
		tosoItemRepository.save(student);
	}

	public TodoItem get(Integer id) {
		return tosoItemRepository.findById(id).get();
	}

	public void delete(Integer id) {
		tosoItemRepository.deleteById(id);
	}
}
