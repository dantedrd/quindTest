package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.EmployerCrudUseCase;
import co.com.quind.transfer.domain.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployerCrudUseCase employerCrudUseCase;
    private final ImageService imageService;

    /**
     * Creates an instance of {@code EmployeeController} with necessary useCase.
     *
     * @param employerCrudUseCase Port for operation calculations.
     */
    public EmployeeController(EmployerCrudUseCase employerCrudUseCase, ImageService imageService) {
        this.employerCrudUseCase = employerCrudUseCase;
        this.imageService=imageService;
    }

    /**
     * Endpoint for calculating the maximum non-negative integer k. Validates the request and
     * delegates the calculation to the application service.
     *
     * @param employee Contains x, y, and n values for the operation.
     * @return ResponseEntity containing the result or error.
     */
   /* @Operation(
            summary = "Saved an employee",
            description = "Saved an employee Returns the employee value saved or errors.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "employee saved successful",
                            content = @Content(schema = @Schema(implementation = GenericResponse.class))
                    )
            }
    )

    @PostMapping
    public ResponseEntity<Object> saveEmployee(
                                               @RequestParam("id") long id,
                                               @RequestParam("nit") long nit,
                                               @RequestParam("name") String name,
                                               @RequestParam("dateEntry") String dateEntry,
                                               @RequestParam(value = "photo", required = false) MultipartFile photoFile,
                                               @RequestParam(value = "photoId", required = false) String photoId,
                                               @RequestParam("position") String position) {
        String fileId=null;

        if(Objects.nonNull(photoId)||"null".equals(photoId)){
            fileId=photoId;
        }

        if(Objects.nonNull(photoFile)){
            fileId=UUID.randomUUID().toString();
            this.imageService.saveImage(fileId,photoFile);
        }

        if(Objects.isNull(fileId)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GenericResponse.of("Archivo no valido", HttpStatus.BAD_REQUEST));
        }

        Employee result= Employee
                    .builder()
                    .id(id)
                    .nit(nit)
                    .name(name)
                    .dateEntry(dateEntry)
                    .photo(fileId)
                    .position(new Gson().fromJson(position, Position.class))
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(GenericResponse.of(employerCrudUseCase.saveEmployee(result), HttpStatus.CREATED));
    }

    @Operation(
            summary = "retrieve all Employees results",
            description = "Fetches all the results of the Employees in company.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "employee saved successful",
                            content = @Content(schema = @Schema(implementation = GenericResponse.class))
                    )
            }
    )

    @GetMapping
    public ResponseEntity<Object> getAllEmployees() {
        List<Employee> result = employerCrudUseCase.getEmployees();
        return ResponseEntity.status(HttpStatus.CREATED).body(GenericResponse.of(result, HttpStatus.CREATED));
    }

    @GetMapping("/images/{idImg}")
    public ResponseEntity<UrlResource> getImage(@PathVariable String idImg){
        UrlResource resource=this.imageService.getImage(idImg);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + resource.getFilename())
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    @PostMapping("/{idEmployee}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long idEmployee){
        this.employerCrudUseCase.deleteEmployee(idEmployee);
        return ResponseEntity.ok().build();
    }*/


}
