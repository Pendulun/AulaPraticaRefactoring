public abstract class Statement {

  public String value(Customer aCustomer) {
    String result = rentalRecordFor(aCustomer);
    return addFooterLines(result, aCustomer.getTotalCharge(),aCustomer.getTotalFrequentRenterPoints());
  }
  
  protected abstract String addFooterLines(String result, double totalCharge, int frequentRenterPoints);
  protected abstract String rentalRecordFor(Customer aCustomer);
}