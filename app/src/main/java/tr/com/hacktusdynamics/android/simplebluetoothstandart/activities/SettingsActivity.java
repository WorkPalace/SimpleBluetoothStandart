package tr.com.hacktusdynamics.android.simplebluetoothstandart.activities;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import tr.com.hacktusdynamics.android.simplebluetoothstandart.R;

public class SettingsActivity extends PreferenceActivity implements
        Preference.OnPreferenceChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Add 'general' preferences, defined in xml file.
        addPreferencesFromResource(R.xml.pref_general);

        //For all preferences, attach an OnPreferenceChangeListener so the UI summary can be
        //updated when the preference changed.
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_location_key)));
        //bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_units_key)));
    }

    /**
     * Attaches a listener so the summary is always updated with the preference value.
     * Also fires the listener once, to initialize the summary (so it shows up before the value
     * is changed.)
     */
    private void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(this);
        // Trigger the listener immediately with the preference's
        // current value.
        onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(), ""));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String stringValue = newValue.toString();
        preference.setSummary(stringValue);

        return true;
    }
}
