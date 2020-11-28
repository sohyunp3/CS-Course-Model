package edu.illinois.cs.cs125.fall2020.mp.models;

/**
 * Model giving access to certain functions from Summary class.
 */
public class Course extends Summary {
  /**
   * Create an empty constructor for Course class.
   */
  public Course() {}

  private String description;
  private float rating;
  /**
   * Provide description when clicked.
   * @return description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Provide rating.
   * @return rating.
   */
  public float getRating() {
    return rating;
  }


}
