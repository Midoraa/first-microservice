package com.test.user.service;

import com.test.user.dto.UserDto;
import com.test.user.entities.UserEntity;
import com.test.user.mapper.UserMapper;
import com.test.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::convertToDTO);

    }

    public boolean createUser(UserDto user) {
        // Kiểm tra tính duy nhất của username
        if (userRepository.existsByUsername(user.getUsername())) {
            return false ;
        }

        UserEntity userEntity = userMapper.convertToEntity(user);
        UserDto userDto = userMapper.convertToDTO(userRepository.save(userEntity));
        return true;
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public ResponseEntity updateUser(Long id, UserEntity userEntity) {
        try {
            UserEntity existingUser = userRepository.findById(id).orElse(null);
            if (existingUser != null) {
                if (!userEntity.getUsername().equals(existingUser.getUsername()) &&
                        userRepository.existsByUsername(userEntity.getUsername())) {
                    return ResponseEntity.badRequest().body("Tên người dùng đã tồn tại!");
                }
                existingUser.setUsername(userEntity.getUsername());
                existingUser.setPassword(userEntity.getPassword());
                existingUser.setGmail(userEntity.getGmail());
                existingUser.setPhoneNumber(userEntity.getPhoneNumber());
                existingUser.setAddress(userEntity.getAddress());

                UserEntity savedUser = userRepository.save(existingUser);
                return ResponseEntity.ok(savedUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi cập nhật người dùng: " + e.getMessage());
        }
    }

    //Phân trang

    public Page<UserDto>  getPaginatedUsers(int pageNo, int pageSize, String key , String oder,String searchQuery){
        Sort sort = Sort.by(Sort.Direction.fromString(oder.toUpperCase()), key);
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        if (searchQuery != null && !searchQuery.isEmpty()) {
            // Thực hiện tìm kiếm với searchQuery
            Page<UserEntity> userEntityPage = userRepository.findByUsernameContainingIgnoreCase(searchQuery, pageable);
            return userEntityPage.map(userEntity -> userMapper.convertToDTO(userEntity));
        } else {
            // Không có searchQuery, thực hiện lấy tất cả người dùng
            Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
            return userEntityPage.map(userEntity -> userMapper.convertToDTO(userEntity));
        }
    }
    public List<UserEntity> findUserByUserName (String name) {
        return userRepository.findByUsernameContaining(name);
    }


}
