package dataproviders;

import org.testng.annotations.DataProvider;
import Utils.LeadFactory;

public class LeadDataProvider {
    @DataProvider(name = "leadDataProvider")
    public static Object[][] testData() {
        return new Object[][] {{LeadFactory.getMandatoryInfoOnlyLead()},
                {LeadFactory.getFullInfoLead()}, {LeadFactory.getHalfInfoLead()}};
    }
}
