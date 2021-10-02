package com.minhdua.apps.document;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Vocabulary")
public class Vocabulary extends AuditEntity{
	private String originWord;
	private Language sourceLanguage;
	private Set<Translation> translations;
	private String stem;
	private Set<String> synonyms;
	private Set<String> antonyms;
	private Set<Topic> topics;
	private Set<String> examples;
	private Set<String> photos;
}