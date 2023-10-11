package com.af.api.expose.utils;

public interface Constants {

    /**
     * APPLICATION CONFIGURATION CONSTANTS
     * */
    public static final String MESSAGE_PROPERTY_FILE_NAME = "messages_en";
    public static final String MESSAGE_PROPERTY_FILE_UTF8 = "UTF-8";
    /**
     * DTO CONSTANTS
     ***/
    public static final String JSON_FORMAT_PATTERN = "yyyy-MM-dd";

    /**
    * API SWAGGER CONSTANTS (FOR CONTROLLER)
    * */
    public static final String REQUEST_MAPPING = "/api/v1/auth";
    public static final String REGISTER_USER_END_POINT = "/register";
    public static final String GET_USER_BY_ID_END_POINT = "/afUser/{id}";
    public static final String TAG_CONTROLLER = "user registration api";
    public static final String API_REGISTER_USER_VALUE = "Register a new user";
    public static final String API_REGISTER_USER_NOTE = "This Post method allows user to self registration with many specific requirements";
    public static final String API_USER_CREATED_SUCCEFULLY_MESSAGE ="The user is created";
    public static final String API_POST_USER_EXIST_BDD =" This AF user name already exist on the database";
    public static final String API_BAD_REQUEST_MESSAGE ="The user entity attribute mustn't be empty or null, and must be valid information for registration";
    public static final String API_GET_USER_BY_ID_VALUE ="Search user from database by his id";
    public static final String API_GET_USER_BY_ID_NOTE="This method allows to search user by his id from the database";
    public static final String API_GET_NOT_VALID_TOKEN ="You must enter a valid token to process within all get requests";
    public static final String API_USER_FOUND_MESSAGE="The user was found";
    public static final String API_USER_NOT_FOUND_MESSAGE="The user doesn't exist in the database";
    public static final String HTTP_RESPONSE_200 ="200";
    public static final String HTTP_RESPONSE_400 ="400";
    public static final String HTTP_RESPONSE_404 ="404";
    public static final String HTTP_RESPONSE_403 ="403";
    public static final String HTTP_RESPONSE_500 ="500";
    /**
    * OPENAPI DOC CONSTANTS
    * */
    public static final String OPEN_API_CONTACT_NAME = "BENDIMERED";
    public static final String OPEN_API_CONTACT_MAIL ="mohammed-el-nadir.bendimered@atos.net";
    public  static final String OPEN_API_INFO_DESCRIPTION = "AF API TO EXPOSE TWO SERVICES FOR USER REGISTRATION PROCESS";
    public  static final String OPEN_API_INFO_TITLE = "MANAGE AF API REGISTRATION SERVICES";
    public  static final String OPEN_API_INFO_VERSION = "0.0.1-SNAPSHOT";
    public static final String OPEN_API_SERVER_DESCRIPTION = "Local environment";
    public static final String OPEN_API_SERVER_URL = "http://localhost:8080/";
    public static final String OPEN_API_SECURITY_SCHEME_NAME = "INSERT TOKEN HERE";
    public static final String OPEN_API_SECURITY_SCHEME_DESCRIPTION = "TOKEN";
    public static final String OPEN_API_SECURITY_SCHEME_SCHEME = "bearer";
    public static final String OPEN_API_SECURITY_BEARER_FORMAT = "JWT";
    /**
     * SECURITY CONFIGURATIONS CONSTANTS
     * */
    public static final String SECURITY_CONF_H2 = "/h2-console/**";
    public static final String SECURITY_CONF_POST_REGISTER = "/api/v1/auth/register";
    public static final String SECURITY_CONF_GET_USER_BY_ID = "/api/v1/auth/afUser/**";
    public static final String SECURITY_CONF_SWAGGER_UI = "/swagger-ui/**";
    public static final String SECURITY_CONF_SWAGGER_UI_HTML = "/swagger-ui.html/**";
    public static final String SECURITY_CONF_API_DOCS_1 = "/v3/api-docs";
    public static final String SECURITY_CONF_API_DOCS_2 = "/v3/api-docs/**";
    public static final String SECURITY_CONF_ERROR = "/error";
    /**
    * JSON PROPERTIES CONSTANTS
    * */
    public static final String JSON_PROPERTY_ACCES_TOKEN = "access_token";
    /**
     * ENTITIES CONSTANTS
     * */
    public static final String ENTITY_TOKEN_TABLE_NAME = "token";
    public static final String ENTITY_TOKEN_JOINT_ATTRIBUTE = "af_user_id";
    public static final String ENTITY_AF_USER_TABLE_NAME = "af_user";
    /**
     * VALIDATOR CLASS CONSTANTS
     * */
    public static final Integer VALIDATOR_AGE = 18;
    /**
     * JWT AUTH FILTER CONSTANTS
     * */
    public static final String JWT_AUTH_HEADER = "Authorization";
    public static final String JWT_BEARER = "Bearer";
    public static final Integer JWT_SUB_AUTH_HEADER = 7;
    /**
     * AOP CONSTANTS
     * **/
    public static final String AOP_AF_USER_CONTROLLER_PATH = "execution(* com.af.api.expose.controller.imp.AfUserControllerApiImp.*(..))";
    public static final String AOP_AF_USER_CONTROLLER_MAIN_METHOD = "startAfUserController()";
    public static final String AOP_AF_USER_SERVICE_PATH = "execution(* com.af.api.expose.service.*.*(..))";
    public static final String AOP_AF_USER_SERVICE_MAIN_METHOD = "startAfUserService()";
    public static final String ANNOTATION_PATH = "@annotation(com.af.api.expose.annotation.ApiAfAnnotation)";
    public static final String AOP_JWT_SERVICE_MAIN_METHOD = "jwtService()";
    public static final String AOP_SECURITY_CONF_MAIN_METHOD = "securityAspect()";
    public static final String AOP_VALIDATE_USER_INFORMATION_MAIN_METHOD = "validateAfUserInfo()";

}
