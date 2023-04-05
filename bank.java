import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Bank
{
	public static void main(String args[])throws IOException
	{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int amt, damt;
		System.out.println("Enter Account Holder Name");
		String name=r.readLine();   //accepts account holder name
		System.out.println("Enter Account Number");
		int accn=sc.nextInt();	//accepts account number
		System.out.println("Enter Account Type");
		System.out.println("1 for Savings Account");
		System.out.println("2 for Current Account");
		int actyp=sc.nextInt();	   //accepts account type
		System.out.println("Enter Account Balance");
		int bal=sc.nextInt();	  //accepts balance
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Fetching Your Details...");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("-----Account Information-----");
		System.out.println("");
		System.out.println("Account Holder: Mr/Mrs."+name);
		System.out.println("Account Number: "+accn);
		if(actyp==1)
		{
			System.out.println("Account Type: Savings Account");
			System.out.println("Over Draft Facility: Disabled");
		}
		else
		{
			System.out.println("Account Type: Current Account");
			System.out.println("Over Draft Facility: Enabled");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Loading Activity List...");
		System.out.println("");
		System.out.println("Activities Available:");
		System.out.println("1. Withdraw Amount");
		System.out.println("2. Deposit Amount");
		System.out.println("3. Check Balance");
		System.out.println("What would you wish to do?");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter the Amount you wish to Withdraw: ");
			amt=sc.nextInt();
			if(amt<=bal)
			{
				bal-=amt;
				System.out.println("Amount of Rs."+amt+" has been deducted from your Account");
				System.out.println("New Account Balance: "+bal);
			}
			else
			{
				if(actyp==1)
					System.out.println("Insufficient Balance, cannot be withdrawn.");
				else
				{
					int diff=amt-bal;
					System.out.println("Over Draft of Rs."+diff+" has been enabled");
					bal=0;
					System.out.println("New Account Balance: "+bal);
				}
			}
		break;
		case 2:
			System.out.println("Enter the Amount you wish to Deposit: ");
			damt=sc.nextInt();
			bal+=damt;
			System.out.println("Deposition of Rs."+bal+" successful");
			System.out.println("New Account Balance: "+bal);
		break;
		case 3:
			System.out.println("Account Balance: "+bal);
		break;
		
		default:
			System.out.println("Sorry! Invalid Command...");
		break;
		
		}
	}
}
