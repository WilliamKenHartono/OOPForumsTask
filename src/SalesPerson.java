public class SalesPerson {

// each object contains details of one salesperson

    private String id;

    private Sales[] salesHistory; // details of the different sales

    private int count = 0; // number of sales made

//constructor for a new salesperson

    public SalesPerson(String id){
        this.id=id;
        this.salesHistory=new Sales[10]; //sales history array with the last 10 sales visible in an array
        this.count=0; //no of sales made always defaults to 0
    }

// constructor for a salesperson transferred (together with their sales details) from another branch

    public SalesPerson(String id, Sales[] s, int c){
        this.id=id;
        this.salesHistory=new Sales[10]; //sales history array with the last 10 sales visible in an array
        this.count=0; //no of sales made always defaults to 0
    }

    public int getCount(){return count;}

    public String getId() {return id;}

    public void setSalesHistory(Sales s){

        salesHistory[count] = s;

        count = count +1;

    }

    public double calcTotalSales(){
        // calculates total sales for the salesperson
        double totalSales = 0;
        for (int i = 0; i < count; i++) {
            totalSales += salesHistory[i].getValue() * salesHistory[i].getQuantity();
        }
        return totalSales;
    }
    //Sales History
    public Sales getSalesHistory(int a){
        if (a >= 0 && a < count){
            return salesHistory[a];
        }
        else{
            return null;
        }
    }
    public Sales largestSale(){
        // calculates the sale with the largest value
        double largestSale = 0;
        Sales largestSalesObject = null;
        for(int i=0; i<count;i++){
            double salesRevenue=salesHistory[i].getValue()*salesHistory[i].getQuantity();
            if (salesRevenue > largestSale){
                largestSale=salesRevenue;
                largestSalesObject = salesHistory[i];
            }
        }
        return largestSalesObject;
    }

}



