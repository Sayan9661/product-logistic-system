package DesignLab;
import java.util.*;
public class BILL {
	Item Item1[];
	String date;
	String Tax_Inv_Num;
	int SGST;
	int CGST;
	int Total;
	BILL(String date,String Tax_Inv_Num,int SGST,int CGST,int Total)
	{
		this.date=date;
		this.Tax_Inv_Num=Tax_Inv_Num;
		this.SGST=SGST;
		this.CGST=CGST;
		this.Total=Total;
	}

}
