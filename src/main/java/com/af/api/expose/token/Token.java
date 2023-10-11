package com.af.api.expose.token;

import com.af.api.expose.model.AfUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static com.af.api.expose.utils.Constants.ENTITY_TOKEN_JOINT_ATTRIBUTE;
import static com.af.api.expose.utils.Constants.ENTITY_TOKEN_TABLE_NAME;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Tag(name = ENTITY_TOKEN_TABLE_NAME)
public class Token {
    @Id
    @GeneratedValue
    public Integer id;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ENTITY_TOKEN_JOINT_ATTRIBUTE)
    public AfUser afUser;
    @Column(unique = true)
    private String token;
}
