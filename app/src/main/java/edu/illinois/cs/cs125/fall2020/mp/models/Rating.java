package edu.illinois.cs.cs125.fall2020.mp.models;

/**
 * Rating class for storing client ratings of courses.
 */
public class Rating {
  /** Rating indicated that the course has not been rated yet. */
  public static final double NOT_RATED = -1.0;
  private String id;
  private double rating;

  /**
   * Empty constructor.
   */
  public Rating() {}
  /**
   * Retrieve rating.
   * @param setId the ID that was retrieved
   * @param setRating the rating that was retrieved
   */
  public Rating(final String setId, final double setRating) {
    id = setId;
    rating = setRating;
  }

  /**
   * Retrieve ID.
   * @return ID
   */
  public String getId() {
    return id;
  }

  /**
   * Retrieve rating.
   * @return rating the course
   */
  public double getRating() {
    return rating;
  }
}
