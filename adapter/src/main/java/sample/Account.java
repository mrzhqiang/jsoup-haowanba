package sample;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Account {

  abstract public String username();

  abstract public String password();

  public static Account create(String username, String password) {
    return builder()
        .username(username)
        .password(password)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_Account.Builder();
  }

  @AutoValue.Builder public abstract static class Builder {
    public abstract Builder username(String username);

    public abstract Builder password(String password);

    public abstract Account build();
  }
}
