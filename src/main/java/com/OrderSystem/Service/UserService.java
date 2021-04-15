package com.OrderSystem.Service;

import com.OrderSystem.data.UserRepository;
import com.OrderSystem.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    private List<User> userList;

    @PostConstruct
    public void postConstruct() {
        this.userList = new ArrayList<>();
    }

    public void createCustomer(User user) {
        userList.add(user);
        repository.save(user);
    }

    public List<User> getCustomers() {
        return repository.findAll();
    }
    public User findCustomer(int id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    public User checkPin(User inputUser) {
        // 1. หา customer ที่มี id ตรงกับพารามิเตอร์
        User storedUser = findCustomer(inputUser.getId());

        // 2. ถ้ามี id ตรง ให้เช็ค pin ว่าตรงกันไหม โดยใช้ฟังก์ชันเกี่ยวกับ hash
        if (storedUser != null) {
            String hashPin = storedUser.getPin();

            if (inputUser.getPin().equals(hashPin))
                return storedUser;
        }
        // 3. ถ้าไม่ตรง ต้องคืนค่า null
        return null;
    }

}
