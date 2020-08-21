package br.com.jonathanphilipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonathanphilipe.converter.DozerConverter;
import br.com.jonathanphilipe.data.model.Person;
import br.com.jonathanphilipe.data.vo.PersonVO;
import br.com.jonathanphilipe.exception.ResourceNotFoundException;
import br.com.jonathanphilipe.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO personVO) {
		var entity = DozerConverter.parseObject(personVO, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public List<PersonVO> findAll() {
		var vo = DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
		
		return vo;
	}
	
	public PersonVO update(PersonVO PersonVO) {
		var entity = repository.findById(PersonVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		
		entity.setFirstName(PersonVO.getFirstName());
		entity.setLastName(PersonVO.getLastName());
		entity.setAddress(PersonVO.getAddress());
		entity.setGender(PersonVO.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
		
		repository.delete(entity);
	}

}
