package com.example.codesnippetmanager.service;

import com.example.codesnippetmanager.entity.CodeSnippet;
import com.example.codesnippetmanager.entity.User;
import com.example.codesnippetmanager.repository.CodeSnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeSnippetService {
	@Autowired
	private CodeSnippetRepository codeSnippetRepository;
	
	public List<CodeSnippet> getAllSnippets() {
		return codeSnippetRepository.findAll();
	}
	
	public CodeSnippet addSnippet(CodeSnippet snippet) {
		return codeSnippetRepository.save(snippet);
	}
}