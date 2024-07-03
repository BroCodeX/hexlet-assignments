package exercise.dto.users;

import exercise.Data;
import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@AllArgsConstructor
@Setter
@Getter
public class UsersPage {
    private List<User> USERS;
    private String term;
}
// END
