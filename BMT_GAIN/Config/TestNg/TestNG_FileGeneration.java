package TestNg;
import java.io.PrintWriter;

import ReusableComponents.*;
import static Config.BaseConfig.TestNgXml;
import static Config.XlsReader.*;

public class TestNG_FileGeneration{
	
	public static void main (String args[]) throws Exception,ArrayIndexOutOfBoundsException
	{
		xmlFetch();
		String TNuseractions= localArray2[1][0];
		System.out.println("The Value of TNuseractions:"+TNuseractions);		
		String TNuseractions1[]=TNuseractions.split("-");
		String tncnt=TNuseractions1[0];
		Integer count =Integer.parseInt(tncnt);	
		String yuseractions= localArray2[1][1];
		System.out.println("The Value of yuseractions :"+yuseractions);
		PrintWriter writer = new PrintWriter(TestNgXml,"UTF-8");
		writer.println("<suite name ="+'"'+"BMT REGRESSION SUITE"+'"'+">");
		writer.println("<test name ="+'"'+"BMT"+'"'+ ">");
		writer.println("<classes>");
		if(yuseractions.equals("Y"))				
		{
	   	writer.println("<class name="+'"'+"User_actions."+TNuseractions1[1]+'"'+"/>");
		}
		writer.println("<methods>");
		for(int i=2;i<=count+1;i++)
		{
		 if(localArray2[i][1].equalsIgnoreCase("y"))
		 {
	   	  writer.println("<include name='"+localArray2[i][0]+"'/>");
	     }
	   }		
        writer.println("</methods>");
		writer.println("</classes>");
		writer.println("</test>");
		writer.println("</suite>");
		writer.close();
		
		htmlReport hf= new htmlReport();		
		hf.createResultFile("C:\\Automation_Framework\\BMT_GAIN\\Test_Output");
		}		
	  }

