package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// BEGIN
@AllArgsConstructor
@Setter
@Getter
public class UserPage {
    private User user;
}
// END
