import java.util.Enumeration;

public class HtmlStatement extends Statement {

  public String value(Customer aCustomer){
    String result = rentalRecordFor(aCustomer);
    return addFooterLines(result, aCustomer.getTotalCharge(), aCustomer.getTotalFrequentRenterPoints());
  }

  protected String addFooterLines(String result, double totalCharge, int frequentRenterPoints){
      result +=  "<P>You owe <EM>" + String.valueOf(totalCharge) + "</EM><P>\n";
      result += "On this rental you earned <EM>" +
      String.valueOf(frequentRenterPoints) +
            "</EM> frequent renter points<P>";
      return result;
  }

  protected String rentalRecordFor(Customer aCustomer){
    Enumeration rentals = aCustomer.getRentals();
    String result = "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for each rental
      result += each.getMovie().getTitle()+ ": " +
            String.valueOf(each.getCharge()) + "<BR>\n";
    }
    return result;
  }
}