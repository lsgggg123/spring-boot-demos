package com.lsgggg123.springboot.jsp.action;

import com.lsgggg123.springboot.jsp.domain.PojoDemo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * swagger controller
 * Created by liushun on 16/5/23.
 */
@Api(basePath = "/swaggerDemo2", value = "swaggerDemo2", description = "swagger demos2", produces = "application/json")
@RestController
@RequestMapping(value = "/swaggerDemo2", produces = MediaType.APPLICATION_JSON_VALUE)
public class MySwaggerController2 {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "原样输出输入的PojoDemo2", notes = "原样输出输入的PojoDemo2")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Fields are with validation errors2"), @ApiResponse(code = 201, message = "")})
    public PojoDemo createLandLord(@Valid @RequestBody PojoDemo demo) {
        return demo;
    }

}
