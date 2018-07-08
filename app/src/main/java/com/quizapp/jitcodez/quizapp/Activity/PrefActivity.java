package com.quizapp.jitcodez.quizapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.R;

import java.util.ArrayList;
import java.util.List;

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            Preference rateUs = findPreference("rate_us");
            rateUs.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    //code for what you want it to do
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + getActivity().getPackageName())));
                    } catch (android.content.ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" +getActivity().getPackageName())));
                    }
                    return true;
                }
            });

            Preference more = findPreference("more");
            more.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    //code for what you want it to do
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + getActivity().getPackageName())));
                    } catch (android.content.ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" +getActivity().getPackageName())));
                    }
                    return true;
                }
            });
            Preference bug = findPreference("bug");
            bug.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    //code for what you want it to do
                    String[] TO = {""};
                    String[] CC = {""};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    String to=getString(R.string.emailId).toString();
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bug ");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Bug Details here");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Report A Bug"));
                       // finish();
                     //   Log.i("Finished sending email...", "");
                    } catch (android.content.ActivityNotFoundException ex) {
                   //     Toast.makeText(, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }

                    return true;
                }
            });

            Preference email = findPreference("email");
            email.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    //code for what you want it to do
                    String[] TO = {""};
                    String[] CC = {""};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    String to=getString(R.string.emailId).toString();
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "To Developer ");
               //     emailIntent.putExtra(Intent.EXTRA_TEXT, "Developer message");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Email to developer"));
                        // finish();
                        //   Log.i("Finished sending email...", "");
                    } catch (android.content.ActivityNotFoundException ex) {
                        //     Toast.makeText(, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });
            Preference friend = findPreference("friend");
            friend.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    final String playStoreLink="\n\nHey check this Application which is a complete solution for you to be a java developer Download Now! \n\n https://play.google.com/store/apps/details?id="+(getResources().getString(R.string.playstore));
                    Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                    whatsappIntent.setType("text/plain");
                    whatsappIntent.setPackage("com.whatsapp");
                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, playStoreLink);
                    try {
                        startActivity(whatsappIntent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getActivity(),"Whatsapp not installed",Toast.LENGTH_SHORT).show();                }


                    return true;
                }
            });
            Preference ref = findPreference("ref");
            ref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                  showDialog();
                    return true;
                }
            });
            Preference about = findPreference("about");
            about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    //code for what you want it to do
                   showAbout();
                    return true;
                }
            });









        }

        private void showAbout() {
            String msg="About Java Programming \n\n" +
                    "#1 Application for Java \n\n" +
                    "No need to carry books for Java programming. This app enables you to carry basic Tutorial in your android. It contains about 100 programs, many Exam Questions and Test also. This app has a very simple user interface and the contents can be easily understood by the users. This will definitely help u for preparing for interviews, tests and in many more ways. Wherever and whenever you require any information about Java you are just a click away \n" +
                    "\n\nAll the best  \n\n" +
                    "Resource Help : ";
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getActivity());
            alertDialogBuilder.setTitle("About Us");
            alertDialogBuilder
                    .setMessage(msg)
                    .setCancelable(true)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        private void showDialog() {

            String msg="Java Programming \n\n============================\n\n" +
                    "Java Programming, [online], Available: http:// www.studytonight.com \n\n============================\n\n" +
                    "Introduction to Java, [online], Available: http://www.eduzip.com/java-programming/ introduction-to-java.html \n\n============================\n\n" +
                    "Java Programming Tutorial, [online], Available: http://www.tutorialspoint.com/ java/index.html \n\n============================\n\n" +
                    "Basic Java Examples, [online], Available: http://www.java-examples.com/basic-java-examples \n\n============================\n\n" +
                    "Java Algorithms, Problems & Programming Examples, [online], Available: http:// www.sanfoundry.com/1000-java-algorithms-problems-programming-examples/ \n\n============================\n\n" +
                    "Java programs, [online], Available: http:// www.programmingsimplified.com/ java-source-codes Core Java Interview Questions, [online], Available: http:// www.javatpoint.com/corejava-interview-questions \n\n============================\n\n" +
                    "Java Interview Questionsjonlinet Available: httn•//www ti itnrialsnnint rnm/iava/ \n\n============================\n\n";
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getActivity());
            alertDialogBuilder.setTitle("References");
            alertDialogBuilder
                    .setMessage(msg)
                    .setCancelable(true)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


    }

}