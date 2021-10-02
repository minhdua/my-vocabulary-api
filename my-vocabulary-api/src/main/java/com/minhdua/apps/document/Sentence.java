package com.minhdua.apps.document;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Sentence")
public class Sentence extends AuditEntity{
	private String originSentence;
	private String translationSentence;
	private Set<Structure> structures;
}