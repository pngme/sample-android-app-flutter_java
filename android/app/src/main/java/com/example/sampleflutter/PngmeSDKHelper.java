package com.example.sampleflutter;

import kotlin.Unit;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.pngme.sdk.library.PngmeSdk;
import androidx.appcompat.app.AppCompatActivity;

public class PngmeSDKHelper extends AppCompatActivity {
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.goHelper();
  }

  private final void goHelper() {
    String sdkToken = this.getIntent().getStringExtra("sdkToken");
    String firstName = this.getIntent().getStringExtra("firstName");
    String lastName = this.getIntent().getStringExtra("lastName");
    String email = this.getIntent().getStringExtra("email");
    String phoneNumber = this.getIntent().getStringExtra("phoneNumber");
    String externalId = this.getIntent().getStringExtra("externalId");
    String companyName = this.getIntent().getStringExtra("companyName");
    boolean hidePngmeDialog = this.getIntent().getBooleanExtra("hidePngmeDialog", false);

    PngmeSdk.INSTANCE.go(
        this,
        sdkToken,
        firstName,
        lastName,
        email,
        phoneNumber,
        externalId,
        companyName,
        hidePngmeDialog,
        this::onComplete);
  }

  private final Unit onComplete() {
    this.finish();
    return Unit.INSTANCE;
  }
}
