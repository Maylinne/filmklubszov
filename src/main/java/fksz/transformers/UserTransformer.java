package fksz.transformers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fksz.authentication.service.AuthenticationService;
import fksz.dao.UserDao;
import fksz.domain.User;
import fksz.domain.UserStatus;
import fksz.dto.UserDto;
import fksz.models.UserModel;
import fksz.requests.UserRequest;

@Component
public class UserTransformer {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationService authService;
	
	@Autowired
	UserDao dao;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public UserDto entitytoDto(User entity) {
		UserDto dto = new UserDto();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPassword(entity.getPassword());
		dto.setGuid(entity.getGuid());
		dto.setRole(entity.getRole());
		dto.setStatus(entity.getStatus());
		// dto.setLastLogin(entity.getLastLogin());
		return dto;
	}

	public User dtoToEntity(UserDto dto) {
		User entity = new User();
		
		if (dto.getId() == 0) {
			entity.setCreatedById(authService.getPrincipalId());
			entity.setCreationTime(LocalDateTime.now());
		} else {
			entity.setCreatedById(dao.findById(dto.getId()).getCreatedById());
			entity.setCreationTime(dao.findById(dto.getId()).getCreationTime());
		}
		
		entity.setLastModifiedId(authService.getPrincipalId());
		entity.setLastModifiedTime(LocalDateTime.now());
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setGuid(dto.getGuid());
		entity.setRole(dto.getRole());
		entity.setStatus(dto.getStatus());
		// entity.setLastLogin(dto.getLastLogin());
		return entity;
	}

	public UserModel dtoToModel(UserDto dto) {
		UserModel model = new UserModel();
		model.setId(dto.getId());
		model.setEmail(dto.getEmail());
		model.setName(dto.getName());
		model.setPassword(dto.getPassword());
		model.setGuid(dto.getGuid());
		model.setRole(dto.getRole());
		model.setStatus(dto.getStatus().toString());
		// model.setLastLogin(dto.getLastLogin().format(formatter));
		return model;
	}

	public UserDto requestToDto(UserRequest request) {
		UserDto dto = new UserDto();
		dto.setId(request.getId());
		dto.setEmail(request.getEmail());
		dto.setName(request.getName());
		dto.setPassword(request.getPassword());
		dto.setGuid(request.getGuid());
		dto.setRole(request.getRole());
		dto.setStatus(UserStatus.valueOf(request.getStatus()));
		// dto.setLastLogin(LocalDateTime.parse(request.getLastLogin(), formatter));
		return dto;
	}

	public List<User> dtosToEntities(List<UserDto> dtos) {
		List<User> entities = new ArrayList<>();
		for (UserDto dto : dtos) {
			entities.add(dtoToEntity(dto));
		}
		return entities;
	}

	public List<UserDto> entiesToDtos(Iterable<User> entities) {
		List<UserDto> dtos = new ArrayList<>();
		for (User entity : entities) {
			dtos.add(entitytoDto(entity));
		}
		return dtos;
	}

	public List<UserModel> dtosToModels(List<UserDto> dtos) {
		List<UserModel> models = new ArrayList<>();
		for (UserDto dto : dtos) {
			models.add(dtoToModel(dto));
		}
		return models;
	}

}
