package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;

@Service
public class ContactServiceImplementation implements ContactService {
    
	@Autowired
	private ContactRepository cdao;
	@Override
	public boolean saveContact(Contact contact) {
        
		
		Contact entity = cdao.save(contact);
		if(entity==null)
		
		{return false;}
		
		else
		{
			return true;
		}
		
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = (List<Contact>) cdao.findAll();
		return list;
		
		
	}

	@Override
	public Optional<Contact> getContactById(Integer contactId) {


		Optional<Contact> entity = cdao.findById(contactId);
		
		return entity;
		
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		cdao.deleteById(contactId);
		if(cdao.existsById(contactId))
		return false;
		else
			return true;
		
	}
	
}
