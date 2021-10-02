package com.minhdua.apps.document;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Topic")
public class Topic extends AuditEntity{
	private String code;
	private String name;
	private Set<String> importFile;
}