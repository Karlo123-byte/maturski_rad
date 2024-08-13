import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
    ATM atm=new ATM();
    Map<Double,String> ministatement=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available balance is : "+atm.getBalance());
}

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount <= atm.getBalance()) {
            ministatement.put(withdrawAmount, " Amount withdrawn");
            System.out.println("Collect the Cash " + withdrawAmount);
            atm.setBalance(atm.getBalance() - withdrawAmount);
            viewBalance();
        } else {
            System.out.println("You dont have enought money to withdraw !!");
        }
        
}

    @Override
    public void depositAmount(double depositAmount) {
        ministatement.put(depositAmount, " Amount Deposited");
        System.out.println(depositAmount+ " Deposited Successfully");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

}

@Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministatement.entrySet()) {
           System.out.println(m.getKey()+""+m.getValue()); 
        }
}
}

