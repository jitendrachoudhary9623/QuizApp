package com.quizapp.jitcodez.quizapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.quizapp.jitcodez.quizapp.Fragments.InterviewFragment;
import com.quizapp.jitcodez.quizapp.Fragments.ProgramFragment;
import com.quizapp.jitcodez.quizapp.Fragments.QuizFragment;
import com.quizapp.jitcodez.quizapp.Fragments.TheoryFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TheoryFragment();
            case 1:
                return new QuizFragment();
            case 2:
                return new ProgramFragment();
            case 3:
                return new InterviewFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}