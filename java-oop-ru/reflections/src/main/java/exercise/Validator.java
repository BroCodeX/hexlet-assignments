package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object inastance) {
        List<Field> fields = List.of(inastance.getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object nullCheck;
                    try {
                        field.setAccessible(true);
                        nullCheck = field.get(inastance);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return nullCheck == null;
                })
                .map(Field::getName)
                .toList();
    }

    public static Map<String, List<String>> advancedValidate(Object inastance) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = inastance.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.isAnnotationPresent(MinLength.class)) {
                    if (field.get(inastance) == null) {
                        result.put(field.getName(), List.of("can not be null"));
                    } else if (field.get(inastance).toString().length() <
                            field.getAnnotation(MinLength.class).minLength()) {
                        result.put(field.getName(), List.of("length less than 4"));
                    }
                } else if(field.isAnnotationPresent(NotNull.class) && !field.isAnnotationPresent(MinLength.class)) {
                    if (field.get(inastance) == null) {
                        result.put(field.getName(), List.of("can not be null"));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
// END
