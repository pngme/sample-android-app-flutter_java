package com.example.sampleflutter;

import android.content.Intent;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "com.flutter.pngme/sdk";

  @Override
  public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    super.configureFlutterEngine(flutterEngine);
    new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
        .setMethodCallHandler(
            (call, result) -> {
              if (call.method.equals("go")) {
                String sdkToken = call.argument("sdkToken");
                String firstName = call.argument("firstName");
                String lastName = call.argument("lastName");
                String email = call.argument("email");
                String phoneNumber = call.argument("phoneNumber");
                String externalId = call.argument("externalId");
                boolean isKycVerified = call.argument("isKycVerified");
                String companyName = call.argument("companyName");
                boolean hidePngmeDialog = call.argument("hidePngmeDialog");

                Intent intent = new Intent(this.getContext(), PngmeSDKHelper.class);
                intent.putExtra("sdkToken", sdkToken);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("email", email);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("externalId", externalId);
                intent.putExtra("isKycVerified", isKycVerified);
                intent.putExtra("companyName", companyName);
                intent.putExtra("hidePngmeDialog", hidePngmeDialog);

                this.getActivity().startActivity(intent);

                result.success("sdk invoked");
              } else {
                result.notImplemented();
              }
            });
  }
}
