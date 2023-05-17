package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 목록 조회: GET /mapping/users
     * 회원 등록:     POST /mapping/users
     * 회원 조회:     GET /mapping/users/id1
     * 회원 수정:     PATCH /mapping/users/id1
     * 회원 삭제:     DELETE /mapping/users/id1
     */

    /**
     * mapping : "/mapping/users"
     * @return : get users
     */
    @GetMapping()
    public String users(){
        return "get users";
    }

    /**
     * mapping : "/mapping/users"
     * @return : post user
     */
    @PostMapping
    public String addUser(){
        return "post user";
    }

    /**
     * GET /mapping/users/{userId}
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId = " + userId;
    }

    /**
     * PATCH /mapping/users/{userId}
     * @param userId
     * @return
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId = " + userId;
    }

    /**
     * DELETE /mapping/users/{userId}
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId = " + userId;
    }



}
