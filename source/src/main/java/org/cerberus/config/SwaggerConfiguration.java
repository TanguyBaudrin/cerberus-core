/*
 * Cerberus Copyright (C) 2013 - 2017 cerberustesting
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.cerberus.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MorganLmd
 */
@Configuration
public class SwaggerConfiguration {

    private static final String PUBLIC_API_VERSION_1 = "1";

/*
    private static final Tag INVARIANT_TAG = new Tag("Invariant", "Description of Invariant endpoint");
    private static final Tag TESTCASE_TAG = new Tag("Testcase", "Description of Testcase endpoint");
    private static final Tag TESTCASEACTION_TAG = new Tag("Testcase Action", "Description of Testcase Control endpoint");
    private static final Tag TESTCASESTEP_TAG = new Tag("Testcase Step", "Description of Testcase Step endpoint");
*/

    private static final String LICENSE_URL = "https://www.gnu.org/licenses/gpl-3.0.en.html";
    private static final String GITHUB_REPOSITORY = "https://github.com/cerberustesting/cerberus-source";

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cerberus public API")
                        .description("Documentation for Cerberus testing public API")
                        .version(PUBLIC_API_VERSION_1)
                        .license(new License().name("GNU General Public License v3.0").url(LICENSE_URL)))
                .externalDocs(new ExternalDocumentation()
                        .description("Cerberus documentation")
                        .url("https://cerberustesting.github.io/documentation_en.html")
                );

    }

/*    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public API version " + PUBLIC_API_VERSION_1)
                .packagesToScan("org.cerberus.api.controller")
                .pathsToMatch("/public/**")
                .build();
    }*/

/*    @Bean
    public Docket swaggerDocV1() {
        return configureVersion(PUBLIC_API_VERSION_1);
    }

    private Docket configureVersion(String version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public API version " + version)
                .ignoredParameterTypes(Principal.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.cerberus.api.controller"))
                .apis(p -> {
                    if (p.headers() != null) {
                        for (NameValueExpression<String> nve : p.headers()) {
                            if ((nve.getName().equals("X-API-VERSION")) && (Objects.equals(nve.getValue(), version))) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(version))
                .tags(INVARIANT_TAG)
                .tags(TESTCASE_TAG)
                .tags(TESTCASEACTION_TAG)
                .tags(TESTCASESTEP_TAG)
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Cerberus public API")
                .description("Documentation for Cerberus testing public API")
                .version(version)
                .license("GNU General Public License v3.0")
                .licenseUrl(LICENSE_URL)
                .termsOfServiceUrl(GITHUB_REPOSITORY)
                .build();
    }*/
}
