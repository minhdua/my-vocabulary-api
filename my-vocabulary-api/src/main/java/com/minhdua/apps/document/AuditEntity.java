package com.minhdua.apps.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class AuditEntity extends BaseEntity {
	@DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
	@CreatedDate
	private LocalDateTime createDate;
	@LastModifiedDate
	@DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
	private LocalDateTime updateDate;
	@CreatedBy
	@DBRef
	private User createBy;
	@DBRef
	@LastModifiedBy
	private User updateBy;
	@Version
	private Integer version;
}