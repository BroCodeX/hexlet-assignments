@import exercise.dto.users.UsersPage
@param UsersPage usersPage


@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" required name="term" value="${usersPage.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
    @if(!usersPage.getUSERS().contains(null) && !usersPage.getUSERS().isEmpty())
        @for(var user : usersPage.getUSERS())
            <div>
                <p>${user.getFirstName()} ${user.getLastName()}</p>
            </div>
        @endfor
    @endif
`
)