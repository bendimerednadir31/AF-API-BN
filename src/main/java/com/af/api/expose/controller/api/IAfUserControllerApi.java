package com.af.api.expose.controller.api;

import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.af.api.expose.utils.Constants.TAG_CONTROLLER;
import static com.af.api.expose.utils.Constants.API_REGISTER_USER_VALUE;
import static com.af.api.expose.utils.Constants.API_REGISTER_USER_NOTE;
import static com.af.api.expose.utils.Constants.HTTP_RESPONSE_200;
import static com.af.api.expose.utils.Constants.API_USER_CREATED_SUCCEFULLY_MESSAGE;
import static com.af.api.expose.utils.Constants.HTTP_RESPONSE_400;
import static com.af.api.expose.utils.Constants.API_BAD_REQUEST_MESSAGE;
import static com.af.api.expose.utils.Constants.HTTP_RESPONSE_500;
import static com.af.api.expose.utils.Constants.API_POST_USER_EXIST_BDD;
import static com.af.api.expose.utils.Constants.API_GET_USER_BY_ID_VALUE;
import static com.af.api.expose.utils.Constants.API_GET_USER_BY_ID_NOTE;
import static com.af.api.expose.utils.Constants.API_USER_FOUND_MESSAGE;
import static com.af.api.expose.utils.Constants.HTTP_RESPONSE_404;
import static com.af.api.expose.utils.Constants.API_USER_NOT_FOUND_MESSAGE;
import static com.af.api.expose.utils.Constants.HTTP_RESPONSE_403;
import static com.af.api.expose.utils.Constants.API_GET_NOT_VALID_TOKEN;


@Tag(name = TAG_CONTROLLER)
public interface IAfUserControllerApi {

    @Operation(summary = API_REGISTER_USER_VALUE, description = API_REGISTER_USER_NOTE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_RESPONSE_200, description = API_USER_CREATED_SUCCEFULLY_MESSAGE,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = HTTP_RESPONSE_400, description = API_BAD_REQUEST_MESSAGE),
            @ApiResponse(responseCode = HTTP_RESPONSE_500, description = API_POST_USER_EXIST_BDD)
    })
    ResponseEntity<AuthenticationResponse> processAfUserRegistration(RegisterRequest request);

    @Operation(summary = API_GET_USER_BY_ID_VALUE, description = API_GET_USER_BY_ID_NOTE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_RESPONSE_200, description = API_USER_FOUND_MESSAGE,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = HTTP_RESPONSE_404, description = API_USER_NOT_FOUND_MESSAGE),
            @ApiResponse(responseCode = HTTP_RESPONSE_403, description = API_GET_NOT_VALID_TOKEN),
    })
    ResponseEntity<UserDetailsResponse> getAfUserById(int id);
}