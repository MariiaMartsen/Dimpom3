import io.qameta.allure.internal.shadowed.jackson.annotation.JsonCreator;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonGetter;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "password", "name"})
public class User {
    private String email;
    private String password;
    public static String name;

    @JsonCreator
    public User(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("name") String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @JsonCreator
    public User(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonGetter("password")
    public String getPassword() {
        return password;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }


}
