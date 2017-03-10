package com.chitfund.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginApp {
	public static void main(String arg[]) throws NumberFormatException, IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String opt="no";
		LoginDao ld = new LoginDao();
		do
		{
			
			System.out.println("1.Login 2.Register");
			
			int choice=Integer.parseInt(bf.readLine());
			if(choice==1)
			{
				ld.login();
			}
			else if(choice==2)
			{
				ld.register();
			}
			System.out.println("Logged Out");
			System.out.println("To continue type yes ");
			opt=bf.readLine();
		}while(opt.equals("yes"));
	}
}
