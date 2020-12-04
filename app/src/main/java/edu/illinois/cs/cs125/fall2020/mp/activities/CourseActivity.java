package edu.illinois.cs.cs125.fall2020.mp.activities;

//import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
//import android.util.Log;

//import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;
//import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;
import edu.illinois.cs.cs125.fall2020.mp.network.Client;

/**
 * CourseActivity that is not implemented yet.
 */
public class CourseActivity extends AppCompatActivity implements Client.CourseClientCallbacks {
  private static final String TAG = CourseActivity.class.getSimpleName();

  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;
  @NonNull private String name;
  @NonNull private String description;
  private ObjectMapper mapper = new ObjectMapper();
  private RatingBar ratingBar;
  private CourseableApplication application;
  private Summary course;
  private CourseActivity self = this;

  /**
   * not implemented yet.
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    //Log.i(TAG, "Course Activity Started");
    super.onCreate(savedInstanceState);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);
    Intent intent = getIntent();
    String toReturn = intent.getStringExtra("COURSE");
    try {
      course = mapper.readValue(toReturn, Course.class);
      // Retrieve the API client from the application and initiate a course summary request
      application = (CourseableApplication) getApplication();
      application.getCourseClient().getCourse(course, this);
//      uuid = application.getClientID();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    //RatingBar bar = (RatingBar) findViewById(R.id.rating);
    ratingBar = findViewById(R.id.rating);
    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
      @Override
      public void onRatingChanged(final RatingBar bar, final float rating, final boolean fromUser) {
//        AlertDialog alertDialog = new AlertDialog.Builder(CourseActivity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage(Float.toString(rating));
//        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                new DialogInterface.OnClickListener() {
//            public void onClick(final DialogInterface dialog, final int which) {
//              dialog.dismiss();
//            }
//            });
//        alertDialog.show();
        Rating r = new Rating(application.getClientID(), (double) rating);
        application.getCourseClient().postRating(course, r, self);
      }
    });
    application.getCourseClient().getRating(course, application.getClientID(), this);
  }
  /**
   * courseResponse.
   * @param summary the summary that was retrieved
   * @param c the course that was retrieved
   */
  @Override
  public void courseResponse(final Summary summary, final Course c) {
    name = summary.getEverything();
    description = c.getDescription();
    binding.name.setText(name);
    binding.description.setText(description);
//    binding.rating.setRating(c.getRating());
  }

  /**
   * Override method from server.
   * @param summary the summary that was retrieved
   * @param rating the rating that was retrieved
   */
  @Override
  public void yourRating(final Summary summary, final Rating rating) {
    binding.rating.setRating((float) rating.getRating());
  }
}
