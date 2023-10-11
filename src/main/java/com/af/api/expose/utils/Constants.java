package com.af.api.expose.utils;

public interface Constants {

    /**
     * APPLICATION CONFIGURATION CONSTANTS
     */
    String MESSAGE_PROPERTY_FILE_NAME = "messages_en";
    String MESSAGE_PROPERTY_FILE_UTF8 = "UTF-8";
    /**
     * DTO CONSTANTS
     ***/
    String JSON_FORMAT_PATTERN = "yyyy-MM-dd";

    /**
     * API SWAGGER CONSTANTS (FOR CONTROLLER)
     */
    String REQUEST_MAPPING = "/api/v1/auth";
    String REGISTER_USER_END_POINT = "/register";
    String GET_USER_BY_ID_END_POINT = "/afUser/{id}";
    String TAG_CONTROLLER = "user registration api";
    String API_REGISTER_USER_VALUE = "Register a new user";
    String API_REGISTER_USER_NOTE = "This Post method allows user to self registration with many specific requirements";
    String API_USER_CREATED_SUCCEFULLY_MESSAGE = "The user is created";
    String API_POST_USER_EXIST_BDD = " This AF user name already exist on the database";
    String API_BAD_REQUEST_MESSAGE = "The user entity attribute mustn't be empty or null, and must be valid information for registration";
    String API_GET_USER_BY_ID_VALUE = "Search user from database by his id";
    String API_GET_USER_BY_ID_NOTE = "This method allows to search user by his id from the database";
    String API_GET_NOT_VALID_TOKEN = "You must enter a valid token to process within all get requests";
    String API_USER_FOUND_MESSAGE = "The user was found";
    String API_USER_NOT_FOUND_MESSAGE = "The user doesn't exist in the database";
    String HTTP_RESPONSE_200 = "200";
    String HTTP_RESPONSE_400 = "400";
    String HTTP_RESPONSE_404 = "404";
    String HTTP_RESPONSE_403 = "403";
    String HTTP_RESPONSE_500 = "500";
    /**
     * OPENAPI DOC CONSTANTS
     */
    String OPEN_API_CONTACT_NAME = "BENDIMERED";
    String OPEN_API_CONTACT_MAIL = "mohammed-el-nadir.bendimered@atos.net";
    String OPEN_API_INFO_DESCRIPTION = "AF API TO EXPOSE TWO SERVICES FOR USER REGISTRATION PROCESS";
    String OPEN_API_INFO_TITLE = "MANAGE AF API REGISTRATION SERVICES";
    String OPEN_API_INFO_VERSION = "0.0.1-SNAPSHOT";
    String OPEN_API_SERVER_DESCRIPTION = "Local environment";
    String OPEN_API_SERVER_URL = "http://localhost:8080/";
    String OPEN_API_SECURITY_SCHEME_NAME = "INSERT TOKEN HERE";
    String OPEN_API_SECURITY_SCHEME_DESCRIPTION = "TOKEN";
    String OPEN_API_SECURITY_SCHEME_SCHEME = "bearer";
    String OPEN_API_SECURITY_BEARER_FORMAT = "JWT";
    /**
     * SECURITY CONFIGURATIONS CONSTANTS
     */
    String SECURITY_CONF_H2 = "/h2-afApiUser/**";
    String SECURITY_CONF_POST_REGISTER = "/api/v1/auth/register";
    String SECURITY_CONF_GET_USER_BY_ID = "/api/v1/auth/afUser/**";
    String SECURITY_CONF_SWAGGER_UI = "/swagger-ui/**";
    String SECURITY_CONF_SWAGGER_UI_HTML = "/swagger-ui.html/**";
    String SECURITY_CONF_API_DOCS_1 = "/v3/api-docs";
    String SECURITY_CONF_API_DOCS_2 = "/v3/api-docs/**";
    String SECURITY_CONF_ERROR = "/error";
    /**
     * JSON PROPERTIES CONSTANTS
     */
    String JSON_PROPERTY_ACCES_TOKEN = "access_token";
    /**
     * ENTITIES CONSTANTS
     */
    String ENTITY_TOKEN_TABLE_NAME = "token";
    String ENTITY_TOKEN_JOINT_ATTRIBUTE = "af_user_id";
    String ENTITY_AF_USER_TABLE_NAME = "af_user";
    /**
     * VALIDATOR CLASS CONSTANTS
     */
    Integer VALIDATOR_AGE = 18;
    /**
     * JWT AUTH FILTER CONSTANTS
     */
    String JWT_AUTH_HEADER = "Authorization";
    String JWT_BEARER = "Bearer";
    Integer JWT_SUB_AUTH_HEADER = 7;
    /**
     * AOP CONSTANTS
     **/
    String AOP_AF_USER_CONTROLLER_PATH = "execution(* com.af.api.expose.controller.imp.AfUserControllerApiImp.*(..))";
    String AOP_AF_USER_CONTROLLER_MAIN_METHOD = "startAfUserController()";
    String AOP_AF_USER_SERVICE_PATH = "execution(* com.af.api.expose.service.*.*(..))";
    String AOP_AF_USER_SERVICE_MAIN_METHOD = "startAfUserService()";
    String ANNOTATION_PATH = "@annotation(com.af.api.expose.annotation.ApiAfAnnotation)";
    String AOP_JWT_SERVICE_MAIN_METHOD = "jwtService()";
    String AOP_SECURITY_CONF_MAIN_METHOD = "securityAspect()";
    String AOP_VALIDATE_USER_INFORMATION_MAIN_METHOD = "validateAfUserInfo()";

}
