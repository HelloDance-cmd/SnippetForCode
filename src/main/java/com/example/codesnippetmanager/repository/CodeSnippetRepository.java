package com.example.codesnippetmanager.repository;

import com.example.codesnippetmanager.entity.CodeSnippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeSnippetRepository extends JpaRepository<CodeSnippet, Long> {
}