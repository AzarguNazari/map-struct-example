package com.example.mapstructdemo;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;
import static org.mapstruct.ReportingPolicy.IGNORE;

@SpringBootApplication
@RestController
public class MapstructDemoApplication implements ApplicationRunner {

	@Autowired
	private PersonMapper personMapper;

	public static void main(String[] args) {

		SpringApplication.run(MapstructDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		PersonDTO personDTO = PersonDTO.builder().id(1L).name("Full name").build();
		Person person = personMapper.toEntity(personDTO);
		System.out.println(person);

		PersonDTO dto = personMapper.toDto(person);
		System.out.println(dto);
	}
}

@Mapper(config = MapperConfig.class)
interface PersonMapper {

//	@Mapping(target = "fullName", source = "name")
	PersonDTO toDto(Person person);

//	@Mapping(target = "name", source = "fullName")
	Person toEntity(PersonDTO personDTO);
}

@org.mapstruct.MapperConfig(unmappedTargetPolicy = IGNORE,
		mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG,
		componentModel = "spring",
		builder = @Builder(disableBuilder = true))
interface MapperConfig {

}
