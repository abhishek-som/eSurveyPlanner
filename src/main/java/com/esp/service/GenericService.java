package com.esp.service;

import java.math.BigDecimal;
import java.util.List;


public interface GenericService<T> {
	
public void add(T t);

public T fetch(BigDecimal id);

public List<T> fetchByParam(Object obj); 

public List<T> fetchAll(); 





}
