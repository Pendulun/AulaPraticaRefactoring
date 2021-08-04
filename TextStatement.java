import java.util.Enumeration;

public class TextStatement extends Statement {
  
  public String value(Customer aCustomer) {
    String result = rentalRecordFor(aCustomer);
    return addFooterLines(result, aCustomer.getTotalCharge(),aCustomer.getTotalFrequentRenterPoints());
  }

  protected String addFooterLines(String result, double totalCharge, int frequentRenterPoints){
    result += "Amount owed is " +
    String.valueOf(totalCharge) + "\n";
    result += "You earned " +
    String.valueOf(frequentRenterPoints) +
    " frequent renter points";
    return result;
  }

  protected String rentalRecordFor(Customer aCustomer){
     Enumeration rentals = aCustomer.getRentals();
      String result = "Rental Record for " + aCustomer.getName() +
      "\n";

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += "\t" + each.getMovie().getTitle()+ "\t" +
         String.valueOf(each.getCharge()) + "\n";
      }
      return result;
  }
}