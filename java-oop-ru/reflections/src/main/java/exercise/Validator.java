package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address adress) {
        List<String> nullFields = new ArrayList<>();
        Field[] fields = adress.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(adress) == null) {
                        nullFields.add(field.getName());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return nullFields;
    }

    public static Map<String, List<String>> advancedValidate(Address adress) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = adress.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.isAnnotationPresent(MinLength.class)) {
                    if (field.get(adress) == null) {
                        result.put(field.getName(), List.of("can not be null"));
                    } else if (field.get(adress).toString().length() <
                            field.getAnnotation(MinLength.class).minLength()) {
                        result.put(field.getName(), List.of("length less than 4"));
                    }
                } else if(field.isAnnotationPresent(NotNull.class) && !field.isAnnotationPresent(MinLength.class)) {
                    if (field.get(adress) == null) {
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
