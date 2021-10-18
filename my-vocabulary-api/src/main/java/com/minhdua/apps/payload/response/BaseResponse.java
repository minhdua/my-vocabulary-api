package com.minhdua.apps.payload.response;

import java.lang.reflect.ParameterizedType;

import com.minhdua.apps.constant.MessageConstants;
import com.minhdua.apps.util.UuidUtils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

	@Default
	protected String id = UuidUtils.uuid();
	protected String messageCode;
	protected String message;
	@Default
	protected HttpStatus status = HttpStatus.OK;

	@SuppressWarnings("unchecked")
	protected String getGenericName() {
		return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
				.getSimpleName();
	}

	public void setMessage(MessageConstants messageConstants) {
		this.message = messageConstants.getMessage();
		this.messageCode = messageConstants.getCode();
	}
}