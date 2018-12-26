package Function;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqlFunctions {
	
	//BACK-END: function to provide a all product list to fit into the data
	public static ResultSet showAllProduct() {
		ResultSet rs = null;
		try {
			// Create the prepared statement for the query
			PreparedStatement ps = Connector.getConnection()
					.prepareStatement("SELECT * FROM PRODUCT"); 
//							"product.productid, " +
//							"product.totalpurchasenumber, " +
//							"product.name, " +
//							"product.type, " +
//							"product.unitprice, " +
//							"product.brand, " +
//							"product.reviewstar " +
//							"FROM " +
//							"product " +
//							"ORDER BY " +
//							"product.unitprice DESC");

			// Set all the input values

			// Execute the query statement and return the books searched
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}
	// BACK-END: provide sort function by price, return a new table
	public static ResultSet showAllProductByPrice(Boolean isDecent) {
		ResultSet rs = null;
		try {
		    PreparedStatement ps;

			if (isDecent) {
				ps = Connector.getConnection()
						.prepareStatement("SELECT " + "    product.productid, "
								+ "    product.totalpurchasenumber, " + "    product.pname, "
								+ "    product.ptype, " + "    product.unitprice, " + "    product.brand, "
								+ "    product.reviewstar, " + " product.supplierID " + "FROM " + "    product "
                                + "ORDER BY " + "    product.unitprice DESC"
                        );
                System.out.println("Ordered");
			}
			else {
				 ps = Connector.getConnection()
						.prepareStatement("SELECT " + "    product.productid, " + "    product.totalpurchasenumber, "
								+ "    product.pname, " + "    product.ptype, " + "    product.unitprice, "
								+ "    product.brand, " + "    product.reviewstar, " + " product.supplierID " + "FROM " + "    product");

                System.out.println("Return to unordered");
			}

			rs = ps.executeQuery();
		} catch (SQLException e) {
            System.out.println("SQL exception");
			e.printStackTrace();
		}
		return rs;

	}
    //TODO: BACK-END: Show supplier order, provide sort function by date from back end, return new list
	///unknown query
	public static ResultSet showAllSupplierOrderByDate(String SupplierID) {
		ResultSet rs = null;
		try {PreparedStatement ps;

				ps = Connector.getConnection()
						.prepareStatement("SELECT " +
								"    orderlist.orderno, " +
								"    orderlist.orderdate, " +
								"    orderlist.customerid, " +
								"    orderincludeproduct.productid, " +
								"    orderincludeproduct.quantity, " +
								"    product.pname " +
								"FROM " +
								"    orderincludeproduct " +
								"    INNER JOIN product ON product.productid = orderincludeproduct.productid " +
								"    INNER JOIN orderlist ON orderincludeproduct.orderno = orderlist.orderno " +
								"WHERE " +
								"    product.supplierid = '" + SupplierID + "'" +
								"ORDER BY " +
								"    orderlist.orderdate DESC"
								);

			//ps.setString(1,SupplierID);
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}

	//TODO: BACK-END: receives one order or orderID, return table with order detail//both supplier and user can use this
	public static ResultSet showOneOrder(String OrderID) {
		ResultSet rs = null;
		try {PreparedStatement ps;
		
		System.out.println(OrderID + "in sql");

				ps = Connector.getConnection()
						.prepareStatement("SELECT " +
								"    orderdetails.totalprice, " +
								"    orderdetails.orderstatus, " +
								"    orderdetails.orderno " +
								"FROM " +
								"    orderdetails " +
								"WHERE " +
								"    orderdetails.orderno = '" + OrderID + "'" );


			// Create the prepared statement for the query


			// Set all the input values
				//ps.setString(1,OrderID);
			// Execute the query statement and return the books searched
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}


	//TODO: BACK-END: receives an column, decide what is the ID of this product//unable to do now

    //TODO: BACK-END: receives Product ID, return table of product details with ID, name, price, track No., review star, brand, supplier Info,
	public static ResultSet showOneProductDetail(String productid) {
		ResultSet rs = null;
		try {
		    PreparedStatement ps;
            System.out.println(productid);
				ps = Connector.getConnection()
						.prepareStatement("SELECT " +
								"    product.totalpurchasenumber, " +
								"    product.pname, " +
								"    product.ptype, " +
								"    product.unitprice, " +
								"    product.reviewstar, " +
								"    product.brand, " +
								"    product.supplierid " +
								"FROM " +
								"    product " +
								"WHERE " +
								"    product.productid = '" + productid + "'");


			// Create the prepared statement for the query


			// Set all the input values
				//ps.setString(1,productid);
			// Execute the query statement and return the books searched
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;}

    //TODO: BACK-END: provide sort function by date from back end, return new list
	public static ResultSet showAllCustomerOrder(String customerid) {
		ResultSet rs = null;
		try {PreparedStatement ps;

				ps = Connector.getConnection()
						.prepareStatement("SELECT " +
								"    orderlist.customerid, " +
								"    orderlist.orderdate, " +
								"    orderlist.orderno " +
								"FROM " +
								"    orderlist " +
								"WHERE " +
								"    orderlist.customerid = '" + customerid + "'"
								);

			//ps.setString(1,customerid);
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;

	}

	//TODO: BACK-END: A search function: put the value into the textfield as the initial value, here, 2 functions needed,
	//1.query 2. display(maybe a class is required) 3. update




	//BACK-END: receive USERID, return a container (like an object or JSON) containing address, city, country, postcode, creditcardNo, cvv, exxpirre date,
	//Billing Object is Generated by an External Class
	//not SQL
    public static ResultSet showOneUserBillingAddressInfo(String USERID) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            System.out.println(USERID);
            ps = Connector.getConnection()
                    .prepareStatement("SELECT " +
                            "    billinginfo.billingid, " +
                            "    billinginfo.cuserid, " +
                            "    billinginfo.billingaddress, " +
                            "    billinginfo.creditcardno, " +
                            "    billinginfo.creditcardexpdate, " +
                            "    billinginfo.creditcardpin, " +
                            "    addressinfo.postcode "
                            + "FROM "
                            + "    billinginfo "
                            + "    INNER JOIN addressinfo ON billinginfo.billingaddress = addressinfo.billingaddress;");

            // Create the prepared statement for the query


            // Set all the input values
            //ps.setString(1,USERID);
            // Execute the query statement and return the books searched
            rs = ps.executeQuery();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rs;
    }

	public static ResultSet showOneUserBillingInfo(String USERID) {
		ResultSet rs = null;
		try {
		    PreparedStatement ps;
            System.out.println(USERID);
				ps = Connector.getConnection()
						.prepareStatement("SELECT " +
								"    billinginfo.billingid, " +
								"    billinginfo.cuserid, " +
								"    billinginfo.billingaddress, " +
								"    billinginfo.creditcardno, " +
								"    billinginfo.creditcardexpdate, " +
								"    billinginfo.creditcardpin, " +
								"    billinginfo.postcode " +
								"FROM " +
								"    billinginfo " +
								"WHERE " +
								"    billinginfo.cuserid = '" + USERID + "'");


			// Create the prepared statement for the query


			// Set all the input values
				//ps.setString(1,USERID);
			// Execute the query statement and return the books searched
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;}
	//TODO: BACK-EDN: A update function: receive these parameters and update in database


	//BACKEND: provide function, check if ID exists, receive string, return boolean

	public static boolean isValidAccountCUSTOMER(String userID) {
		try {
			PreparedStatement ps = Connector.getConnection().prepareStatement("SELECT * FROM CUSTOMER WHERE USERID = '" + userID + "'");
			//ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//BACKEND: provide function, check if ID exists, receive string, return boolean
	public static boolean isValidAccountSupplier(String userID) {
		try {
			PreparedStatement ps = Connector.getConnection().prepareStatement("SELECT * FROM SUPPLIERPROFILE WHERE USERID= '" + userID + "'");
			//ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

    public static int updateOneBankBillingInfo(String USERID, String Address, String CREDICARDNO, String CREDITCARDEXPDATE, String CREDITCARDPIN, String POSTCODE) {
        int state=0;
        try {
            Statement stmt=Connector.getConnection().createStatement();
            System.out.println(Address);
            System.out.println(CREDICARDNO);
            System.out.println(CREDITCARDEXPDATE);
            System.out.println(CREDITCARDPIN);
            System.out.println(POSTCODE);
            stmt.executeUpdate("UPDATE billinginfo set billingaddress= '" + Address + "', CREDITCARDNO= '" + CREDICARDNO +
                            "', CREDITCARDEXPDATE = '" + CREDITCARDEXPDATE + "', CREDITCARDPIN = '" + CREDITCARDPIN + "', POSTCODE = '" + POSTCODE + "'" +
                    " where cuserid='" + USERID + "'");
            stmt.executeUpdate("commit");

        } catch (SQLException e) {
            e.printStackTrace();

            return -1;

        } finally {


        }

        return state;
	}

//    public static int updateOneBankBillingInfo(String USERID, String Address, String CREDICARDNO, String CREDITCARDEXPDATE, String CREDITCARDPIN, String POSTCODE) {
//        int state=0;
//        try {PreparedStatement ps;
//            ps = Connector.getConnection()
//                    .prepareStatement("UPDATE BILLINGINFO SET BillingAddress = '"+Address+"', CREDITCARDNO = '"+CREDICARDNO+"', CREDITCARDEXPDATE = '"+CREDITCARDEXPDATE+"',CREDITCARDPIN = '"+CREDITCARDPIN+"', POSTCODE = '"+POSTCODE+"'   WHERE CUSERID = '"+USERID + "'");
//            System.out.println("Updated in SQL");
//            state=ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return -1;
//        }
//        return state;
//	}

    public static int updateOneBankAccount(String USERID, String BankAccount) throws SQLException {
        int state=0;
        PreparedStatement ps;
            ps = Connector.getConnection()
                    .prepareStatement("UPDATE COLLECTIONMONEYINFO" +" SET BANKACCOUNT = '"+BankAccount +"' WHERE SUSERID = '"+USERID + "'");

            state=ps.executeUpdate();

        return state;
	}

    public static ResultSet showOneBankAccount(String USERID) {
        ResultSet rs = null;
        try {PreparedStatement ps;
            ps = Connector.getConnection()
                    .prepareStatement("SELECT BANKACCOUNT FROM COLLECTIONMONEYINFO WHERE SUSERID = '"+USERID + "'");
            rs = ps.executeQuery();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rs;

	}

	public static boolean checkProductOwner(String PID, String SupplierID) {

	    try{
            PreparedStatement ps = Connector.getConnection().prepareStatement(
                    "SELECT * FROM PRODUCT WHERE SUPPLIERID= '" + SupplierID + "', PRODUCTID = " + PID +  "'");
            //ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Check ProductOwner Exception");
        }
        return false;
    }

    public static int updateProduct(String PID, String Name, String Category, String Price, String SupplierID) {
        int state=0;
        try {
            PreparedStatement ps;
            if(!checkProductOwner(PID, SupplierID)) {
                return -1;
            }
            ps = Connector.getConnection()
                    .prepareStatement("UPDATE PRODUCT" +" SET PNAME = '"+Name +"', PTYPE = '" + Category
                            + "', UNITPRICE = '" + Price + "  WHERE PRODUCTID = '"+PID +"'");

            state=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return state;
    }

    //BACKEND: provide function, checkif productID exists, receive string, return boolean
    public static boolean isProductexsit (int ProductID){
        try{
            PreparedStatement ps = Connector.getConnection().prepareStatement ("SELECT * FROM PRODUCT WHERE PRODUCTID =?");
            ps.setInt(1, ProductID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //BACKEND: a product can be added by the supplier if the product doens't exist
    public static void addProduct (int PRODUCTID, int TOTALPURCHASENUMBER, String NAME, String TYPE,
                                   int UNITPRICE, String BRAND, float REVIEWSTAR, String SUPPLIERID){
        if (isProductexsit(PRODUCTID)){

        }
        else {
            try {
                PreparedStatement ps = Connector.getConnection().prepareStatement("INSERT INTO PRODUCT"
                        +"(PRODUCTID, TOTALPURCHASENUMBER, NAME, TYPE, UNITPRICE, BRAND, REVIEWSTAR, SUPPLIERID)"
                        +"VALUES (?,?,?,?,?,?,?,?)");
                ps.setInt(1,PRODUCTID);
                ps.setInt(2,TOTALPURCHASENUMBER);
                ps.setString(3,NAME);
                ps.setString(4,TYPE);
                ps.setInt(5,UNITPRICE);
                ps.setString(6,BRAND);
                ps.setFloat(7,REVIEWSTAR);
                ps.setString(8,SUPPLIERID);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }


    public static ResultSet searchProduct(String PNAME,String PTYPE,float UNITPRICEUPPER,float UNITPRICELOWER,String BRAND, float REVIEWSTARUPPER,float REVIEWSTARLOWER ) {
        ResultSet rs = null;
        try {PreparedStatement ps;
            String a=String.valueOf(UNITPRICEUPPER);
            String b=String.valueOf(UNITPRICELOWER);
            String c=String.valueOf(REVIEWSTARUPPER);
            String d=String.valueOf(REVIEWSTARLOWER);
            ps = Connector.getConnection().prepareStatement("SELECT " +
                    "    product.productid, " +
                    "    product.pname, " +
                    "    product.ptype, " +
                    "    product.unitprice, " +
                    "    product.brand, " +
                    "    product.supplierid, " +
                    "    product.reviewstar, " +
                    "    product.totalpurchasenumber " +
                    "FROM " +
                    "    product " +
                    "WHERE " +
                    "    ( " +
                    "            product.pname ='" + PNAME + "' " +
                    "        OR " +
                    "            '" + PNAME + "' IS NULL " +
                    "    ) AND ( " +
                    "            product.ptype = '" + PTYPE + "' " +
                    "        OR " +
                    "            '" + PTYPE + "' IS NULL " +
                    "    ) AND ( " +
                    "            product.unitprice <= "+a+" " +
                    "        AND " +
                    "            product.unitprice >= "+b+" " +
                    "    ) AND ( " +
                    "            product.brand = '" + BRAND + "' " +
                    "        OR " +
                    "            '" + BRAND + "' IS NULL " +
                    "    ) AND ( " +
                    "            product.reviewstar <= "+c+" " +
                    "        AND " +
                    "            product.reviewstar >= "+d+" " +
                    "    )");
            // Create the prepared statement for the query
            // Set all the input values
            //ps.setString(1,USERID);
            // Execute the query statement and return the books searched
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;}

    //BACKEND:provides customers with the product type that recives the highest rating
    public static ResultSet mostpopulartype (){
        ResultSet rs = null;
        try {
            PreparedStatement ps;

            ps = Connector.getConnection()
                    .prepareStatement( "SELECT ptype AS productype, AVG(reviewstar) as avgrating "
                            + "FROM product "
                            + "GROUP BY ptype "
                            + "HAVING AVG(reviewstar) = (SELECT MAX(AVG(reviewstar)) AS avgmaxrating "
                            + "                          FROM product "
                            + "                          GROUP BY ptype)");

            rs = ps.executeQuery();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return rs;

    }

    public static ResultSet mostpurchasedtype (){
        ResultSet rs = null;
        try {
            PreparedStatement ps;

            //use select ? as to create table head

            ps = Connector.getConnection()
                    .prepareStatement( "SELECT brand, SUM(totalpurchasenumber) as totalPurchase "
                            + "FROM product "
                            + "GROUP BY brand "
                            + "HAVING SUM(totalpurchasenumber) = (SELECT MAX(SUM(totalpurchasenumber)) AS totalPurchaseSum "
                            + "                          FROM product "
                            + "                          GROUP BY brand)");


            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    public static ResultSet showsupplierinfofromproduct(String ProductID) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;

            ps = Connector.getConnection().prepareStatement("SELECT " +
                    "    userprofile.uname, " +
                    "    userprofile.phoneno " +
                    "FROM " +
                    "    product " +
                    "INNER JOIN" +
                    "    userprofile " +
                    "ON" +
                    "    product.supplierid = userprofile.userid " +
                    "WHERE " +
                    "    product.productid = '" + ProductID + "'" );

            rs = ps.executeQuery();
            return rs;


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rs;

    }

}
