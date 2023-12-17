package spring5.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring5.cms.domain.models.User;
import spring5.cms.domain.service.UserService;
import spring5.cms.domain.vo.UserRequest;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok((List<User>) userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> newUser(UserRequest userRequest) {
        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,
                                           UserRequest userRequest) {
        return new ResponseEntity<>(userService.update(id, userRequest), HttpStatus.OK);
    }
}
