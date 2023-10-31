package com.example.bottom_navigation_view_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.app.Application;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

public class startCallActivity extends AppCompatActivity {
    EditText userIdEditText;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userIdEditText = findViewById(R.id.user_id_edit_text);
        startBtn = findViewById(R.id.start_button);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = userIdEditText.getText().toString().trim();
                if (userID.isEmpty()) {
                    return;
                }

                // Add your logic here to handle the user's input
                //start services
                startService(userID);
                Intent intent = new Intent(startCallActivity.this,CallActivity.class);
                intent.putExtra("userID",userID);
                startActivity(intent);

            }
        });
    }

    void startService(String userID) {
        Application application = getApplication();
        long appID =1207162512; // Replace with your actual App ID
        String appSign = "3f028ddb97faac1652b966f19bfbe24dd7434009a3789662036c5df56ffa27a7"; // Replace with your actual App Sign
        String userName = userID; // Replace with the user's name

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit=true;

        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound="zego_uikit_sound_call";
        notificationConfig.channelName= "CallInvitation";
        // notificationConfig.setSound("zego_uikit_sound_call");
        //notificationConfig.setChannelID("CallInvitation");

        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(),appID,appSign,userID,userName,callInvitationConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}