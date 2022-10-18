package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Lead;

public interface LeadService {

	public void saveOneLead(Lead lead);

	public Lead getOneLead(long id);

	public void deletOnelead(long id);

	public List<Lead> findAllLeads();

}
