package com.spacoeducar.spacoeducar.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacoeducar.spacoeducar.dtos.UserDto;
import com.spacoeducar.spacoeducar.enums.Role;
import com.spacoeducar.spacoeducar.exceptions.ResourceNotFoundException;
import com.spacoeducar.spacoeducar.model.User;
import com.spacoeducar.spacoeducar.repositories.UserRepository;

@Service
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        logger.info("Buscando usuário de id " + id);
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado usuário com este id: " + id));
    }

    public List<User> findAll() {
        logger.info("Buscando todos os usuários");
        List<User> users = userRepository.findAll();
        return users;
    }

    public User create(UserDto dto) {
        logger.info("Criando usuário");
        User user = User.builder()
        .name(dto.getName())
        .email(dto.getEmail())
        .cpf(dto.getCpf())
        .password(dto.getPassword())
        .role("root".equals(dto.getName()) ? Role.ADMIN : Role.USER)
        .build();
        return userRepository.save(user);
    }

    public User update(UserDto user) {
        logger.info("Atualizando usuário de id " + user.getId());

        User entity = userRepository.findById(user.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Não foi encontrado usuário com este id: " + user.getId()));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());

        return userRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deletando usuário de id " + id);
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Não foi encontrado usuário com este id: " + id));
        userRepository.delete(user);
        logger.info("Usuário " + id + " deletado!");
    }
}
