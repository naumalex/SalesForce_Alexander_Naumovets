package pages.dataproviders;

import org.testng.annotations.DataProvider;
import pages.Utils.AccountFactory;
import pages.Utils.LeadFactory;

public class AccountDataProvider {
    @DataProvider(name = "accountDataProvider")
    public static Object[][] testData() {
        return new Object[][] {{AccountFactory.getMandatoryInfoOnlyAccount()},
                {AccountFactory.getFullInfoAccount()}, {AccountFactory.getHalfInfoAccount()}};
    }
}
