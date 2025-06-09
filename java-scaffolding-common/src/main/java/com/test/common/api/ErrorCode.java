package com.test.common.api;

/**
 * ErrorCode interface defines the structure for error codes used in the application.
 * It provides methods to retrieve the code and message associated with an error.
 * Implementing classes should provide specific error codes and messages.
 *
 * 錯誤代碼 interface
 */

public interface ErrorCode {
    /**
     * Code
     */
    String getCode();

    /**
     * Message of Code
     *
     * @return message of code
     */
    String getMessage();
}
