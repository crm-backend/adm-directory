package com.crm.apis;

import com.crm.apis.common.services.init.CommonApplication;
import com.crm.apis.common.services.init.CommonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class AdmDirectoryApplication extends CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmDirectoryApplication.class, args);
    }

}
