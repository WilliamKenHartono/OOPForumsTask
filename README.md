# OOPForumsTask
A large company with locations in different cities has taken an OOP approach in creating an administration program that manages all aspects of its business. These aspects include:
·the sale of all the different products that the company manages
·the salaries for managers, office staff and sales personnel.

1.(a) By making use of an example from the above scenario, distinguish between a class and an instantiation of a class. (3 points)
Class is the blueprint to create an object that contains a would be objects traits and behaviors
The Instantiation of a class is an object created from a class
A sale class would be the blueprint containing traits that describe object price and who and when an item was bought. When a sale is made, The instantiation of a class would create a sale object that introduces values to the class without altering the original blueprint.
A salaries class would contain placeholder details such as employee name, current salary and job. When a new personnel is hired, an instantiation of the salaries class would describe the salaries class tailored to the specific instantiation trigger.
The different modules in the program each open a graphical user interface (GUI). Each GUI has a similar design but contains differences specific to each module.
(b) By giving two examples, explain how the principles of inheritance can be incorporated into the design of this administration program. (4 points)
The administration program could have an option that describes the salary class and once it is opened, it shows the various salaries of the types of staff as described in the jobSalary subclass.
A 2nd example would be that the administration program could have different levels of access and depending on the credentials imputed would display the result of different subclasses. This would take the form of “baseGUI”, “normalGUI” and “adminGUI” the “normalGUI” subclass would have standard features inherited from the “baseGUI” with some restrictions while the “adminGUI” would have more access but still draws the features from the “baseGUI”.
(c) Describe how the use of libraries can facilitate the development of programs like this company’s administration program. (3 points)
Libraries can increase efficiency of programs as they are a preinstalled code that can allow the code to do a job much faster as opposed to rewriting the code manually. A scanner program can allow the code a simple way to read inputs on console which allows an easy way for the code to receive inputs which allow the user to add, update or delete data such as salary information.
2. The company employs several sales personnel to sell its products to different retailers. Each branch of the company keeps track of its own sales with a suite of programs that include the two classes SalesPerson and Sales.
 
public class SalesPerson {
// each object contains details of one salesperson
private String id;
private Sales[] salesHistory; // details of the different sales
private int count = 0; // number of sales made
//constructor for a new salesperson
public SalesPerson(String id){
// code missing
}
 
// constructor for a salesperson transferred (together with their sales details) from another branch
public SalesPerson(String id, Sales[] s, int c){
// code missing
}
 
public int getCount(){return count;}
public String getId() {return id;}
public void setSalesHistory(Sales s){
salesHistory[count] = s;
count = count +1;
}
 
public double calcTotalSales(){
// calculates total sales for the salesperson
// code missing
}
 
public Sales largestSale(){
// calculates the sale with the largest value
// code missing
}
}
 
Each instance variable is initialized when a SalesPerson object is instantiated.
(a) Complete the constructor public SalesPerson(String id), from the SalesPerson class. (2 points)

```
    public SalesPerson(String id){
        this.id=id;
        this.salesHistory=new Sales[10]; //sales history array with the last 10 sales visible in an array
        this.count=0; //no of sales made always defaults to 0
    }
```

(b) Explain why accessor methods are necessary for the SalesPerson class. (3 points)
Accessor methods are necessary so that the SalesPerson class can provide access to the private instance variables. The accessor methods can set and modify the private instance variables for the specific SalesPerson class.
public class Sales {
// each object contains details of one sale
private String itemId;     // id of the item
private double value;      // the price of one item
private int quantity;      // the number of the items sold
// constructor missing
public double getValue() {return value;}
public int getQuantity() {return quantity;}
}
 
(c) (i) Construct unified modelling language (UML) diagrams to clearly show the relationship between the SalesPerson and Sales classes.
Note: There is no need to include mutator or accessor methods or a constructor. (4 points)

(c) (ii) Outline a negative effect that a future change in the design of the Sales object might have on this suite of programs. (2 points)
 A future change in the design of the Sales effect might have a negative effect on this suite of programs as classes that rely on the Sales class may have to be changed to accommodate for the changes made to the sales class. If there are multiple programs that all rely on the same Sales class, each of these programs would have to be altered individually which is a time consuming and laborious process that is prone to bugs.
The company employs several sales personnel. The different salesPerson objects are held in the array salesPeople. The Driver class contains various methods that operate on the SalesPerson and Sales classes. The Driver class contains the following code:
public static void main(String[] args){
SalesPerson[] salesPeople = new SalesPerson[6];
salesPeople[0] = new SalesPerson("100");
salesPeople[1] = new SalesPerson("101");
salesPeople[2] = new SalesPerson("102");
salesPeople[0].setSalesHistory(new Sales("A100",300.00,10));
salesPeople[0].setSalesHistory(new Sales("A200",1000.00,2));
salesPeople[1].setSalesHistory(new Sales("A300",2550.40,10));
System.out.println(salesPeople[2].getId());
System.out.println(salesPeople[0].getCount());
System.out.println(salesPeople[1].getSalesHistory(0).getValue());
System.out.println(salesPeople[0].calcTotalSales());
 }
(d) State the output after running this code. (4 points)
Output:
```
102 
2 
2550.4
5000.0 
```
(e) Construct the method calcTotalSales(), in the SalesPerson class that calculates the total value of the sales for a specific SalesPerson object. (5 points)
```
    public double calcTotalSales(){
        // calculates total sales for the salesperson
        double totalSales = 0;
        for (int i = 0; i < count; i++) {
            totalSales += salesHistory[i].getValue() * salesHistory[i].getQuantity();
        }
        return totalSales;
    }
 ```
 
The salesPeople array contains 100 instantiated objects. The company wishes to reward the salesperson whose sales have the largest total value.
(f) By making use of any previously written methods, construct the method highest(), that returns the ID of the salesperson whose sales have the largest total value. (5 points)
```
    public static String highest(SalesPerson[] salesPeople){
        SalesPerson highest = salesPeople[0];
        for (SalesPerson current : salesPeople){
            if(current.calcTotalSales() > highest.calcTotalSales()){
                highest = current;
            }
        }
        return highest.getId();
    }
```

(g) Construct the method addSales(Sales s, String id), in the Driver class, that will add a new Sales object s, to the salesperson with a specified ID.
Note: You can assume that the ID is a valid one. (4 points)
```
    public void addSales(Sales s, String id, SalesPerson[] salesPeople) {
        for (SalesPerson current : salesPeople) {
            if (current.getId().equals(id)) {
                current.setSalesHistory(s);
                break;
            }
        }
    }
```
 
A further class in this suite of programs is the Payroll class. This class is run at the end of each month to calculate each salesperson’s salary, which is based on the sales that have been made during that month.
(h) Suggest changes that must be made to the SalesPerson class and/or the Sales class to allow these calculations to be made. (3 points)
A salesperson class would need an update that references the time a sale was made. Each salesperson class would need to be changed in order to show the sum of the sales made within a month.
(i) Discuss the use of polymorphism that occurs in this suite of programs. (3 points)
Polymorphism allows data to have the same instance variables from the same constructor while at the same time have a unique identity for each individual object depending on how the object is declared. This allows each object to be classified with different traits as the same constructor is reusable. This can save time in coding as each individual object need not be coded the same way every time.
