package pro.sky.java.course2.weblibrary5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployeeExistsException extends RuntimeException {
}
