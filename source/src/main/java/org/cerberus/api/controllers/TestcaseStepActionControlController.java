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
package org.cerberus.api.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cerberus.api.controllers.wrappers.ResponseWrapper;
import org.cerberus.api.dto.v001.TestcaseStepActionControlDTOV001;
import org.cerberus.api.dto.views.View;
import org.cerberus.api.mappers.v001.TestcaseStepActionControlMapperV001;
import org.cerberus.api.services.PublicApiAuthenticationService;
import org.cerberus.crud.service.ITestCaseStepActionControlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author mlombard
 */
@AllArgsConstructor
@Tag(name = "Testcase Control")
@Hidden
@RestController
@RequestMapping(path = "/public/testcasestepactioncontrols")
public class TestcaseStepActionControlController {

    private static final Logger LOG = LogManager.getLogger(TestcaseStepActionControlController.class);

    private static final String API_VERSION_1 = "X-API-VERSION=1";
    private static final String API_KEY = "X-API-KEY";
    private final TestcaseStepActionControlMapperV001 controlMapper;
    private final ITestCaseStepActionControlService controlService;
    private final PublicApiAuthenticationService apiAuthenticationService;

    @Operation(summary = "Find a testcaseStepActionControl by key (testFolderId, testcaseId, stepId, actionId, controlId)")
    @ApiResponse(responseCode = "200", description = "operation successful",
            content = @Content(schema = @Schema(implementation = TestcaseStepActionControlDTOV001.class)))
    @JsonView(View.Public.GET.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{testFolderId}/{testcaseId}/{stepId}/{actionId}/{controlId}", headers = {API_VERSION_1}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseWrapper<TestcaseStepActionControlDTOV001> findControlByKey(
            @PathVariable("testFolderId") String testFolderId,
            @PathVariable("testcaseId") String testcaseId,
            @PathVariable("stepId") int stepId,
            @PathVariable("actionId") int actionId,
            @PathVariable("controlId") int controlId,
            @RequestHeader(name = API_KEY, required = false) String apiKey,
            Principal principal) {
        this.apiAuthenticationService.authenticate(principal, apiKey);
        return ResponseWrapper.wrap(
                this.controlMapper.toDTO(
                        this.controlService.findTestCaseStepActionControlByKey(
                                testFolderId, testcaseId, stepId, actionId, controlId)
                )
        );
    }
}
