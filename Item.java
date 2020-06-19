package DesignLab;
import java.util.*;

public class Item {
	String Item_Name;
	int Item_Quantity;
	String Prod_Id;
	int Cost_Price;
	int MRP;
	int Disc;
	String Category;
	Item(String Item_Name,int Item_Quantity,String Prod_Id,int Cost_Price,int MRP,int Disc,String Category)
	{
		this.Item_Name=Item_Name;
		this.Item_Quantity=Item_Quantity;
		this.Prod_Id=Prod_Id;
		this.Cost_Price=Cost_Price;
		this.MRP=MRP;
		this.Disc=Disc;
		this.Category=Category;
	}
}