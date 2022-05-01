package com.example.domain.view.home.view.setting;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.domain.view.home.setting.R;

import java.util.Vector;

public class SettingsFragment extends PreferenceFragmentCompat {

    private Preference password, email, nickname, profile_image, rules, dark_mode, alarm_setting, app_version,
            FAQ, notice, user_agreement, personal_information_handling_policy, licence, information_using_agreement, withdrawal, logout;

//    private static final int NULL_DESTINATION_ID = -1;
//    private enum EPreference {
//        ePassword("password", R.id.action_settingsFragment_to_settingPassword),
//        eEmail("email", R.id.action_settingsFragment_to_settingEmail),
//        eNickName("nickname", R.id.action_settingsFragment_to_settingNickname),
//        ;
//
//        private String key;
//        private int destinationId;
//
//        // @Getter
//        // @ Setter
//        private EPreference(String key, int destinationId){ // lombok
//            this.key=key;
//            this.destinationId=destinationId;
//        }
//        public String getKey() { return key; }
//        public void setKey(String key) { this.key = key; }
//        public int getDestinationId() { return destinationId; }
//        public void setDestinationId(int destinationId) { this.destinationId = destinationId; }
//    }

//    private Vector<Preference> preferenceVector;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.fragment_setting_home, rootKey);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        this.preferenceVector = new Vector<>();
//
//        for(EPreference ePreference : EPreference.values()){
//            Preference preference = this.findPreference(ePreference.getKey());
//            if(ePreference.getDestinationId() != NULL_DESTINATION_ID){
//                preference.setOnPreferenceClickListener(clickedPreference -> {
//                    this.navigateTo(ePreference.getDestinationId());
//                    return true;
//                });
//            }
//            this.preferenceVector.add(preference);
//        }


        this.password = findPreference("password");
        this.email = (Preference) findPreference("email");
        this.nickname = (Preference) findPreference("nickname");
        this.profile_image = (Preference) findPreference("profile_image");
        this.rules = (Preference) findPreference("rules");
        this.dark_mode = (Preference) findPreference("dark_mode");
        this.alarm_setting = (Preference) findPreference("alarm_setting");
        this.app_version = (Preference) findPreference("app_version");
        this.FAQ = (Preference) findPreference("FAQ");
        this.notice = (Preference) findPreference("notice");
        this.user_agreement = (Preference) findPreference("user_agreement");
        this.personal_information_handling_policy = (Preference) findPreference("personal_information_handling_policy");
        this.licence = (Preference) findPreference("licence");
        this.information_using_agreement = (Preference) findPreference("information_using_agreement");
        this.withdrawal = (Preference) findPreference("withdrawal");
        this.logout = (Preference) findPreference("logout");

        this.password.setOnPreferenceClickListener(preference -> {
            this.navigateTo(R.id.action_settingsFragment_to_settingPassword);
            return true;
        });
        this.email.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_settingEmail);
                return true;
            }
        });
        this.nickname.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_settingNickname);
                return true;
            }
        });
        this.rules.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_settingRule);
                return true;
            }
        });
    }

    private void navigateTo(int destinationId) { Navigation.findNavController(this.getView()).navigate(destinationId); }
}