package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : address.getClass().getMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var returnedType = method.getReturnType().getSimpleName();
                System.out.printf("Method %s returns a value of type %s%n",
                        method.getName(), returnedType);
            }
        }
        // END
    }
}
