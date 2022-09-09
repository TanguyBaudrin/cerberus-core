/**
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

package org.cerberus.core.api.dto.v001;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.cerberus.core.api.dto.views.View;

import java.util.List;

/**
 * @author lucashimpens
 */
@Data
@Builder
@Jacksonized
@ApiModel(value = "CampaignExecution")
public class CampaignExecutionDTOV001 {

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 0)
    private String campaignExecutionId;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 1)
    private String ciResult;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 2)
    private String startDate;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 3)
    private String endDate;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 4)
    private long durationInMillis;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 5)
    private String campaignName;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 6)
    private String description;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 7)
    private CampaignExecutionResultDTOV001 result;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 8)
    private String browserstackBuildHash;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 9)
    private String lambdaTestBuild;

    @JsonView(value = {View.Public.GET.class})
    @ApiModelProperty(position = 10)
    private List<TestcaseExecutionDTOV001> executions;
}
