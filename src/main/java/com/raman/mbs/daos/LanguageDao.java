package com.raman.mbs.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.Language;

public interface LanguageDao extends JpaRepository<Language,Integer> {
	 public Optional<Language> findByLanguageName(String languageName);

}
