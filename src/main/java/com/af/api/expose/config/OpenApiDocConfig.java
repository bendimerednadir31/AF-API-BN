package com.af.api.expose.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import static com.af.api.expose.utils.Constants.OPEN_API_CONTACT_NAME;
import static com.af.api.expose.utils.Constants.OPEN_API_CONTACT_MAIL;
import static com.af.api.expose.utils.Constants.OPEN_API_INFO_DESCRIPTION;
import static com.af.api.expose.utils.Constants.OPEN_API_INFO_TITLE;
import static com.af.api.expose.utils.Constants.OPEN_API_INFO_VERSION;
import static com.af.api.expose.utils.Constants.OPEN_API_SERVER_DESCRIPTION;
import static com.af.api.expose.utils.Constants.OPEN_API_SERVER_URL;
import static com.af.api.expose.utils.Constants.OPEN_API_SECURITY_SCHEME_NAME;
import static com.af.api.expose.utils.Constants.OPEN_API_SECURITY_SCHEME_DESCRIPTION;
import static com.af.api.expose.utils.Constants.OPEN_API_SECURITY_SCHEME_SCHEME;
import static com.af.api.expose.utils.Constants.OPEN_API_SECURITY_BEARER_FORMAT;


@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = OPEN_API_CONTACT_NAME,
                        email = OPEN_API_CONTACT_MAIL
                ),
                description = OPEN_API_INFO_DESCRIPTION,
                title = OPEN_API_INFO_TITLE,
                version = OPEN_API_INFO_VERSION
        ),
        servers = {
                @Server(
                        description = OPEN_API_SERVER_DESCRIPTION,
                        url = OPEN_API_SERVER_URL
                )
        },
        security = {
                @SecurityRequirement(name = OPEN_API_SECURITY_SCHEME_NAME)
        }

)
@SecurityScheme(
        name = OPEN_API_SECURITY_SCHEME_NAME,
        description = OPEN_API_SECURITY_SCHEME_DESCRIPTION,
        scheme = OPEN_API_SECURITY_SCHEME_SCHEME,
        type = SecuritySchemeType.HTTP,
        bearerFormat = OPEN_API_SECURITY_BEARER_FORMAT,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiDocConfig {
}
