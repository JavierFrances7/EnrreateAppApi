package com.enrreateapp.service;

import java.util.Collection;

import com.enrreateapp.model.Establecimiento;

public interface EstablecimientoServiceInterface {
	public abstract void createEstablecimiento(Establecimiento establecimiento);

	public abstract void updateEstablecimiento(String uidEstablecimiento, Establecimiento establecimiento);

	public abstract void deleteEstablecimiento(String uidEstablecimiento);

	public abstract Collection<Establecimiento> getEstablecimientos();
}