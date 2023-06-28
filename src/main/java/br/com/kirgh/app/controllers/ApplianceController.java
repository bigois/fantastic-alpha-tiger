package br.com.kirgh.app.controllers;

import br.com.kirgh.app.dtos.ApplianceDTO;
import br.com.kirgh.app.entities.Appliance;
import br.com.kirgh.app.services.ApplianceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ApplianceController class is a Java REST controller that handles requests related to creating new appliances.
 */
@RestController
@RequestMapping(path = "/api/v1/appliances", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Appliances", description = "Set of API methods for appliance data manipulation")
@SuppressWarnings({"unused", "SpringJavaAutowiredFieldsWarningInspection"})
public class ApplianceController {
    @Autowired
    private ApplianceService applianceService;

    /**
     * This is a Java function that creates a new appliance using the data provided in the ApplianceDTO object.
     *
     * @param applianceDTO The parameter {@code applianceDTO} is of type {@code ApplianceDTO} and is annotated with {@code @RequestBody} and
     *                     {@code @Valid}. It represents the data transfer object that contains the information needed to create a new appliance. The
     *                     {@code @RequestBody} annotation indicates that the parameter should be populated with the
     * @return The method {@code applianceRegister} is returning a {@code ResponseEntity} object, which can contain any type of
     * response data along with an HTTP status code. The actual response data being returned depends on the implementation
     * of the {@code createAppliance} method in the {@code applianceService} class.
     */
    @Operation(
        summary = "Creates a new appliance to an existent address",
        description = "Method for creating a new appliance to an existent user address and returning a JSON response with the new appliance's ID"
    )
    @PostMapping
    public ResponseEntity<String> applianceRegister(@RequestBody @Valid ApplianceDTO applianceDTO) {
        JSONObject response = new JSONObject();
        Appliance appliance = applianceService.createAppliance(applianceDTO);

        response.put("resourceId", appliance.getId());
        response.put("message", "appliance successfully registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}
