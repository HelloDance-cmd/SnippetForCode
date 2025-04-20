package com.example.codesnippetmanager.controller;

import com.example.codesnippetmanager.entity.CodeSnippet;
import com.example.codesnippetmanager.service.CodeSnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
public class CodeSnippetController {
	@Autowired
	private CodeSnippetService codeSnippetService;
	
	@GetMapping
	public List<CodeSnippet> getAllSnippets() {
		return codeSnippetService.getAllSnippets();
	}
	
	@PostMapping
	public CodeSnippet addSnippet(@RequestBody CodeSnippet snippet) {
		return codeSnippetService.addSnippet(snippet);
	}
}