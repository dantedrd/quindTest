package co.com.quind.transfer.config.exception;

/**
 * Enumerates standard error codes and messages for consistent error handling across the application.
 * This enumeration centralizes the definitions of error codes and their corresponding messages,
 * promoting uniformity in error responses and simplification of error diagnosis.
 *
 * <p>Each enumerated value represents a specific type of error, associated with a unique error code
 * and a descriptive message. These values can be used throughout the application to ensure a
 * standardized response to different error conditions.</p>
 *
 * <p>Error codes include but are not limited to:</p>
 * <ul>
 *     <li>GENERIC_ERROR: For general, uncontrolled errors.</li>
 *     <li>APP_LOAD_ERROR: Issues encountered during application startup or loading.</li>
 *     <li>DATABASE_CONNECTION_ERROR: Failures in establishing database connections.</li>
 *     <li>INVALID_ARGUMENT_ERROR: Invalid arguments provided to methods or functions.</li>
 *     <li>INVALID_REQUEST_ERROR: Malformed requests such as unreadable or missing message bodies.</li>
 *     <li>INVALID_PARAMS_ERROR: Requests containing invalid or malformed data.</li>
 *     <li>OPERATION_ADAPTER_SAVE_ERROR: Issues saving records to the database.</li>
 *     <li>OPERATION_ADAPTER_FIND_ERROR: Issues retrieving records from the database.</li>
 *     <li>OPERATION_SERVICE_ERROR_CALCULATE: Errors in mathematical operation calculations.</li>
 *     <li>OPERATION_USE_CASE_ERROR_CALCULATE: Failures in business logic or operation execution during calculation use cases.</li>
 *     <li>OPERATION_CONTROLLER_ERROR_CALCULATE: Failures in controller layer during calculation processing.</li>
 *     <li>OPERATION_USE_CASE_ERROR_RESULTS: Failures in business logic or operation execution when retrieving results.</li>
 *     <li>OPERATION_CONTROLLER_ERROR_RESULTS: Failures in controller layer when processing result retrieval.</li>
 * </ul>
 */
public enum SPError {
    INVALID_AGE_CLIENT(1001, "El cliente es menor de edad"),
    INVALID_CLIENT_HAS_PRODUCTS(1002, "El cliente tiene productos"),

    INVALID_DATE_FORMAT(1003, "La fecha tiene un formato invalido dd/MM/yyyy"),

    INVALID_PARAMETERS(1004, "Algunos parametros son invalidos"),

    INVALID_ACCOUNT_AMOUNT(1005, "la cuenta no puede tener una saldo menor a $0"),

    INVALID_USER_NOT_EXIST(1006, "El usuario no exista"),

    TYPE_ACCOUNT_NOT_VALID(1007, "el tipo de cuenta no es valido"),

    TYPE_TRANSFER_NOT_VALID(1008, "el tipo de cuenta no es valido"),

    STATE_ACCOUNT_NOT_VALID(1009, "el estado de la cuenta no es valido"),

    NOT_FOUND_ACCOUNT(1010, "La cuenta no existe"),

    ERROR_DELETE_USER(1010, "Ocurrio un error eliminando el cliente"),

    ERROR_DELETE_ACCOUNT(1010, "Ocurrio un error eliminando la cuenta"),

    ACCOUNT_NOT_ACTIVE(1011, "no se puede hacer el procedimiento ya que la cuenta esta inactiva"),
    VALUE_IS_UPPER_TO_VALUE_ACCOUNT(1012, "El valor es superior a lo que tiene la cuenta");

    private final int errorCode;
    private final String errorMessage;

    /**
     * Constructs an SPError enum value with the specified error code and message.
     *
     * @param errorCode    The unique code associated with the error.
     * @param errorMessage The human-readable message describing the error.
     */
    SPError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Retrieves the error code of this error.
     *
     * @return The integer code representing the specific error.
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Retrieves the error message of this error.
     *
     * @return The string message associated with the error.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
