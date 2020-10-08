package android.example.com.visualizerpreferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() {
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // DONE (5) In SettingsFragment's onCreatePreferences method add the preference file using the
        //   addPreferencesFromResource method
        addPreferencesFromResource(R.xml.pref_visualizer);
    }
}