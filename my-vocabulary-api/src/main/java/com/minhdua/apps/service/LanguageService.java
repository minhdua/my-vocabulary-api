package com.minhdua.apps.service;

import com.minhdua.apps.document.Language;
import com.minhdua.apps.dto.LanguageDto;
import com.minhdua.apps.repository.LanguageReactiveRepository;

import org.springframework.stereotype.Service;

@Service
public class LanguageService extends BaseService<Language, LanguageDto, LanguageReactiveRepository> {

}