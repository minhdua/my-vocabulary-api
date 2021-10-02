package com.minhdua.apps.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public abstract class AuditEntity extends BaseEntity {
	@DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
	@CreatedDate
	private LocalDateTime createDate;
	@LastModifiedDate
	@DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
	private LocalDateTime updateDate;
	@CreatedBy
	private String createBy;
	@LastModifiedBy
	private String updateBy;
}