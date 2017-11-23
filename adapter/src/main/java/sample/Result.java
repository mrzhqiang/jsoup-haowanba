package sample;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Result {

  public abstract int code();

  public abstract String content();

  public abstract String error();

  public abstract boolean isOK();

  public static Result create(int code, String content, String error, boolean isOK) {
    return builder()
        .code(code)
        .content(content)
        .error(error)
        .isOK(isOK)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_Result.Builder();
  }

  @AutoValue.Builder public abstract static class Builder {
    public abstract Builder code(int code);

    public abstract Builder content(String content);

    public abstract Builder error(String error);

    public abstract Builder isOK(boolean isOK);

    public abstract Result build();
  }
}
