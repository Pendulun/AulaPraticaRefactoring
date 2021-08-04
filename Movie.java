public class Movie {

  public static final int  CHILDRENS = 2;
  public static final int  REGULAR = 0;
  public static final int  NEW_RELEASE = 1;

  private String _title;
  private Price _price ;

  public Movie(String title, int priceCode) {
      _title = title;
      this.setPriceCode(priceCode);
  }

  public int getPriceCode() {
      return this._price.getPriceCode();
  }

  public String getTitle (){
      return _title;
  }

  public double getCharge(int daysRented){
    return this._price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented){
    int frequentRenterPoints = 1;
    // add bonus for a two day new release rental
    if ((this.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
      frequentRenterPoints ++;
    return frequentRenterPoints;
  }

  public void setPriceCode(int arg) {
      switch (arg) {
         case REGULAR:
            this._price = new RegularPrice();
            break;
         case CHILDRENS:
            this._price = new ChildrensPrice();
            break;
         case NEW_RELEASE:
            this._price = new NewReleasePrice();
            break;
         default:
            throw new IllegalArgumentException("Incorrect Price Code");
      }
   }
}
