package br.com.hominid.soothe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("br.com.hominid.soothe.controller"),
        @ComponentScan("br.com.hominid.soothe.infra.security")})
@EnableJpaRepositories("br.com.hominid.soothe.repository")
@EntityScan("br.com.hominid.soothe.entities")
public class SootheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SootheApplication.class, args);
    }

}
