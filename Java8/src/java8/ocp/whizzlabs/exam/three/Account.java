package java8.ocp.whizzlabs.exam.three;

public class Account {
	private int accountNo;
	private double balance;

	/**
	 * @param accountNo
	 * @param balance
	 */
	public Account(int accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return accountNo + " : " + balance;
	}

}
