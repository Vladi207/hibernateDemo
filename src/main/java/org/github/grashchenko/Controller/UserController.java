package org.github.grashchenko.Controller;

import org.github.grashchenko.dao.UserDAO;
import org.github.grashchenko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userDAO.get(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody User user) {
        userDAO.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @Valid @RequestBody User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userDAO.delete(id);
    }
}
