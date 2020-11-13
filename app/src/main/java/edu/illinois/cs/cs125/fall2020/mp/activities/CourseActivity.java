package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;

//import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;

/**
 * CourseActivity that is not implemented yet.
 */
public class CourseActivity extends AppCompatActivity {
  private static final String TAG = CourseActivity.class.getSimpleName();

  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;
  private ObjectMapper mapper = new ObjectMapper();
  /**
   * not implemented yet.
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    //Log.i(TAG, "Course Activity Started");
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);
    Intent intent = getIntent();
    String toReturn = intent.getStringExtra("COURSE");
    try {
      Course course = mapper.readValue(toReturn, Course.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    //Log.d(TAG, intent.getStringExtra("TITLE"));
    binding.textview.setText(intent.getStringExtra("TITLE"));
  }
}
