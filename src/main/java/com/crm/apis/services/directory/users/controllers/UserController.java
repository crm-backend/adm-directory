package com.crm.apis.services.directory.users.controllers;

import com.crm.apis.common.services.web.controllers.CommonController;
import com.crm.apis.common.services.web.response.Response;
import com.crm.apis.common.services.web.response.query.RequestFilter;
import com.crm.apis.services.directory.users.forms.User;
import com.crm.apis.services.directory.users.forms.UserAddress;
import com.crm.apis.services.directory.users.forms.UserEmail;
import com.crm.apis.services.directory.users.forms.UserFilter;
import com.crm.apis.services.directory.users.services.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User  API.
 *
 * @author PoleData.
 */
@Api( description="API for Users.")
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController extends CommonController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/filter")
    public Response find(@RequestBody UserFilter filter, Pageable pageable) throws Exception {
        return Response.ok().setPayload(userService.find(filter,pageable));
    }

    @PostMapping("")
    public Response createNewUser(@RequestBody User user) {
        return Response.ok().setPayload(userService.createNewUser(user));
    }

    @PutMapping("")
    public Response updateUser(@RequestBody User user) {
        return Response.ok().setPayload(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return Response.ok();
    }

    @PutMapping("{id}/suspend")
    public Response suspendedUser(@PathVariable Long id) {
        userService.suspendedUser(id,true);
        return Response.ok();
    }

    @PutMapping("{id}/unsuspend")
    public Response unsuspend(@PathVariable Long id) {
        userService.suspendedUser(id,false);
        return Response.ok();
    }

    @PutMapping("{id}/setadmin")
    public Response adminUser(@PathVariable Long id) {
        userService.adminUser(id,true);
        return Response.ok();
    }
    @PutMapping("{id}/notadmin")
    public Response unSetAdminUser(@PathVariable Long id) {
        userService.adminUser(id,false);
        return Response.ok();
    }

    @PutMapping("{id}/enable")
    public Response enableUser(@PathVariable Long id) {
        userService.enableUser(id,true);
        return Response.ok();
    }
    @PutMapping("{id}/desable")
    public Response desable(@PathVariable Long id) {
        userService.enableUser(id,false);
        return Response.ok();
    }

    @PostMapping("/add/email")
    public Response addEmail(@RequestBody UserEmail userEmail) {
        return Response.ok().setPayload(userService.addEmail(userEmail));
    }
    @PutMapping("/add/email")
    public Response updateEmail(@RequestBody UserEmail userEmail) {
        return Response.ok().setPayload(userService.updateEmail(userEmail));
    }

    @DeleteMapping("/{id}/email")
    public Response deleteEmail(@PathVariable Long id) {
        userService.deleteEmail(id);
        return Response.ok();
    }


    @PostMapping("/add/address")
    public Response addAddress(@RequestBody UserAddress userAddress) {
        return Response.ok().setPayload(userService.addAddress(userAddress));
    }
    @PutMapping("/add/address")
    public Response updateAddress(@RequestBody UserAddress userAddress) {
        return Response.ok().setPayload(userService.updateAddress(userAddress));
    }

    @DeleteMapping ("/{id}/address")
    public Response deleteAddress(@PathVariable Long id) {
        userService.deleteAddress(id);
        return Response.ok();
    }

}