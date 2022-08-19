package dataproviders;

import Utils.AccountFactory;
import Utils.ContactFactory;
import org.testng.annotations.DataProvider;

public class ContactDataProvider {
    @DataProvider(name = "contactDataProvider")
    public static Object[][] testData() {
        return new Object[][] {{ContactFactory.getMandatoryInfoOnlyAccount()},
                {ContactFactory.getFullInfoAccount()}, {ContactFactory.getHalfInfoAccount()}};
    }
}
