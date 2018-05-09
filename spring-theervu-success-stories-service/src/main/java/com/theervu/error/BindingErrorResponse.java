package com.theervu.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BindingErrorResponse {
	private List<BindingError> bindingErrors=new ArrayList<BindingError>();

 
	/**
	 * @return the bindingErrors
	 */
	public List<BindingError> getBindingErrors() {
		return bindingErrors;
	}


	/**
	 * @param bindingErrors the bindingErrors to set
	 */
	public void setBindingErrors(List<BindingError> bindingErrors) {
		this.bindingErrors = bindingErrors;
	}


	public void addErrors(BindingResult bindingResult) {
		List<FieldError> listFieldErrs=bindingResult.getFieldErrors();
		List<BindingError> listBindingError=listFieldErrs.stream().map(fieldErr->{
		        BindingError bindingError=new BindingError();
		        bindingError.setFieldCode(fieldErr.getCode());
		        bindingError.setErrorMessage(fieldErr.getDefaultMessage());
		        bindingError.setObjectName(fieldErr.getObjectName());
		        return bindingError;
						}
				).collect(Collectors.toList());
		 setBindingErrors(listBindingError); 
		
	}
	
	public String toJSON() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String errorsAsJSON = "";
		try {
			errorsAsJSON = mapper.writeValueAsString(getBindingErrors());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return errorsAsJSON;
	}

}
