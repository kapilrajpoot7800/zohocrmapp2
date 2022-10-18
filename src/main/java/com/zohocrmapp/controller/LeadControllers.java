package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadControllers {
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
	
	
	@RequestMapping("/viewLeadPage")
	public String viewLeadPage() {
		return "create_lead";
	}

	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("Lead") Lead lead ,ModelMap model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead",lead);
		return "lead_info";
	}

	@RequestMapping("/composeEmail")
	public String sendEmail(@RequestParam("email") String email,ModelMap model) {
		model.addAttribute("email",email);
	
		return "compose_email";
	}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,ModelMap model) {

		Lead lead = leadService.getOneLead(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveOneLead(contact);
		leadService.deletOnelead(lead.getId());
		List<Contact> contacts = contactService.getAllContact();
		model.addAttribute("contacts",contacts);
		return "list_contact";

	}
	@RequestMapping("/listall")
	public String  getAllLeads(ModelMap model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads" ,leads);
		return "list_lead";
	}
	
	@RequestMapping("/findLeadById")
	public String findLeadById(@RequestParam("id") long id ,ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead" ,lead);
		return "lead_info";
		
	}
	
}
