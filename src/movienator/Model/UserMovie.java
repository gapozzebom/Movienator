package movienator.Model;

public class UserMovie {
    
    private int userId;
    private int movieId;
    private String userName;
    private String title;
    private boolean wish;
    private boolean watch;
    private String review;
    private String rate;

    public boolean isWatch() {
        return watch;
    }

    public void setWatch(boolean watch) {
        this.watch = watch;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
        
    public boolean isWish() {
        return wish;
    }

    public void setWish(boolean wish) {
        this.wish = wish;
    }
        
    public int getUserId() {
        return userId;
    }

    public void setUserId(int UserId) {
        this.userId = UserId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int MovieId) {
        this.movieId = MovieId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
}
