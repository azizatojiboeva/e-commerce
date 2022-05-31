package uz.azi.ecomusers.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.azi.ecomusers.dtos.UserCreateDto;
import uz.azi.ecomusers.dtos.UserDTo;
import uz.azi.ecomusers.dtos.UserUpdateDto;
import uz.azi.ecomusers.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/ecomuser/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "400", description = "User already exist",
                            content = @Content(schema =
                            @Schema(implementation = RuntimeException.class)))})
    @Operation(summary = "create user", description = "Creates new user")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody UserCreateDto dto) {
        return service.create(dto);
    }


    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "User updated successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(schema =
                            @Schema(implementation = RuntimeException.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, username already exist",
                            content = @Content(schema = @Schema(implementation = RuntimeException.class))
                    )
            })
    @Operation(summary = "update user", description = "Updates new user info")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
    public Boolean update(@PathVariable(name = "id") Long id, @RequestBody UserUpdateDto dto) {
        return service.update(id, dto);
    }


    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "User deleted successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(schema =
                            @Schema(implementation = RuntimeException.class)))
            })
    @Operation(summary = "delete user", description = "Deletes  user ")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }


    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = " Retrieved all Users successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "404", description = "Users not found",
                            content = @Content(schema =
                            @Schema(implementation = RuntimeException.class)))
            })
    @Operation(summary = "get user", description = "Gets  user info")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTo> users(){
        return service.getAll();
    }


    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = " Retrieved one User by id successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(schema =
                            @Schema(implementation = RuntimeException.class)))
            })
    @Operation(summary = "get user", description = "Gets  user info")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserDTo getOne(@PathVariable(name = "id") Long id){
        return service.getOne(id);
    }








}
