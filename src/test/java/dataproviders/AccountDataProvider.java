package dataproviders;

import org.testng.annotations.DataProvider;
import Utils.AccountFactory;

public class AccountDataProvider {
    @DataProvider(name = "accountDataProvider")
    public static Object[][] testData() {
        return new Object[][] {{AccountFactory.getMandatoryInfoOnlyAccount()},
                {AccountFactory.getFullInfoAccount()}, {AccountFactory.getHalfInfoAccount()}};
    }
}
