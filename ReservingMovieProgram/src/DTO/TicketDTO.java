package DTO;

public class TicketDTO {
    private String customerName; 
    private String customerId; 
    private String seatNumber; 
    private String theatherName; 
    private String roomNumber;
    private String movieName; 
    private String date; 
    private String screenTime;

    
    private int cost; 
    private int personCount;

    public TicketDTO() {
        super();
    }

	public TicketDTO(String customerName, String customerId, String seatNumber, String theatherName, String roomNumber,
            String movieName, String date, String screenTime, int cost, int personCount) {
        super();
        this.customerName = customerName;
        this.customerId = customerId;
        this.seatNumber = seatNumber;
        this.theatherName = theatherName;
        this.roomNumber = roomNumber;
        this.movieName = movieName;
        this.date = date;
        this.screenTime = screenTime;
        this.cost = cost;
        this.personCount = personCount;
    }
    
    @Override
    public String toString() {
        String text =
                customerName+" " + customerId + " "+ seatNumber + " " + theatherName + " " +roomNumber+ " " +movieName
                + " " + date
                + " " + screenTime
                + " " + cost +" " + personCount;
        return text;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTheatherName() {
        return theatherName;
    }

    public void setTheatherName(String theatherName) {
        this.theatherName = theatherName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getScreenTime() {
        return screenTime;
    }

    public void setScreenTime(String screenTime) {
        this.screenTime = screenTime;
    }
    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
