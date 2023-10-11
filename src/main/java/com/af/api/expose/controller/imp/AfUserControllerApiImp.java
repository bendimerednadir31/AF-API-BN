package com.af.api.expose.controller.imp;

import com.af.api.expose.controller.api.IAfUserControllerApi;
import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;
import com.af.api.expose.service.IAfUserService;
import com.af.api.expose.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping(Constants.REQUEST_MAPPING)
public class AfUserControllerApiImp implements IAfUserControllerApi {

    @Autowired
    private IAfUserService _afUserService;

    @PostMapping(value = Constants.REGISTER_USER_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> processAfUserRegistration(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(_afUserService.registerAfUser(request));
    }

    @GetMapping(value = Constants.GET_USER_BY_ID_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetailsResponse> getAfUserById(@PathVariable int id) {
        UserDetailsResponse userDetailsResponse = _afUserService.getUserById(id);
        return ResponseEntity.ok(userDetailsResponse);
    }
}
