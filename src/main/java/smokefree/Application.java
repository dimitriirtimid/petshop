package smokefree;

import io.micronaut.context.annotation.Bean;
import io.micronaut.runtime.Micronaut;
import io.micronaut.security.token.jwt.signature.SignatureConfiguration;
import io.micronaut.security.token.jwt.validator.JwtTokenValidator;
import io.micronaut.security.token.validator.TokenValidator;
import smokefree.projection.InitiativeProjection;

import javax.inject.Inject;
import javax.sql.DataSource;

public class Application {

    public static String hostname = "localhost";

    @Bean
    public InitiativeProjection initiativeProjection() {
        return new InitiativeProjection();
    }



    public static void main(String[] args) {
        if (args.length > 0)
            hostname = args[0];
        Micronaut.run(Application.class);
    }
}