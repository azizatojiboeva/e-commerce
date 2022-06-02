package uz.azi.ecomorder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.azi.ecomorder.dtos.OrderCreateDto;
import uz.azi.ecomorder.dtos.OrderUpdateDTo;
import uz.azi.ecomorder.service.OrderService;

@RestController
@RequestMapping(value = "/ecomorder/order")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService service;

    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "Order created successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, username already exist",
                            content = @Content(schema = @Schema(implementation = RuntimeException.class))
                    )
            })
    @Operation(summary = " Order create", description = "Creates new order info")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody OrderCreateDto dto){
        return service.create(dto);
    }

    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "Order updated successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request!",
                            content = @Content(schema = @Schema(implementation = RuntimeException.class))
                    )
            })
    @Operation(summary = " Order update", description = "Updates  order info")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Boolean update(@RequestBody OrderUpdateDTo dto){
        return service.update(dto);
    }

    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",
                    description = "Order deleted successfully",
                    content = @Content(schema = @Schema(implementation = Long.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request, username already exist",
                            content = @Content(schema = @Schema(implementation = RuntimeException.class))
                    )
            })
    @Operation(summary = " Order delete", description = "Deletes order info")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Void delete(@PathVariable(name = "id") Long id){
         return service.delete(id);
    }















}
