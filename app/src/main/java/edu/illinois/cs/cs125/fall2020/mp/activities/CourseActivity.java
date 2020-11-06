package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * CourseActivity that is not implemented yet.
 */
public class CourseActivity extends AppCompatActivity {
  private static final String TAG = CourseActivity.class.getSimpleName();

  /**
   * not implemented yet.
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    //Log.i(TAG, "Course Activity Started");
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    Log.d(TAG, intent.getStringExtra("TITLE"));
  }
}
