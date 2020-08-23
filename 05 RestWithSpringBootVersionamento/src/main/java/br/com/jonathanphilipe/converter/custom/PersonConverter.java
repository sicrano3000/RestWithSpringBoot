package br.com.jonathanphilipe.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.jonathanphilipe.data.model.Person;
import br.com.jonathanphilipe.data.vo.PersonVOV2;

@Service
public class PersonConverter {

	public PersonVOV2 converterEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		
		return vo ;
	}
	
	public Person converterVOToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return entity ;
	}
	
}
