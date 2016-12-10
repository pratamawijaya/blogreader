package com.pratamawijaya.blog.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class MovieModel {
  @SerializedName("poster_path")
  @Expose
  private String posterPath;
  @SerializedName("adult")
  @Expose
  private Boolean adult;
  @SerializedName("overview")
  @Expose
  private String overview;
  @SerializedName("release_date")
  @Expose
  private String releaseDate;
  @SerializedName("genre_ids")
  @Expose
  private List<Integer> genreIds = new ArrayList<Integer>();
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("original_title")
  @Expose
  private String originalTitle;
  @SerializedName("original_language")
  @Expose
  private String originalLanguage;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("backdrop_path")
  @Expose
  private String backdropPath;
  @SerializedName("popularity")
  @Expose
  private Double popularity;
  @SerializedName("vote_count")
  @Expose
  private Integer voteCount;
  @SerializedName("video")
  @Expose
  private Boolean video;
  @SerializedName("vote_average")
  @Expose
  private Double voteAverage;

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public List<Integer> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(List<Integer> genreIds) {
    this.genreIds = genreIds;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public Double getPopularity() {
    return popularity;
  }

  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  public Integer getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(Integer voteCount) {
    this.voteCount = voteCount;
  }

  public Boolean getVideo() {
    return video;
  }

  public void setVideo(Boolean video) {
    this.video = video;
  }

  public Double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }
}
