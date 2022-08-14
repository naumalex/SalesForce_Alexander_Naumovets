package pages.dataproviders;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import pages.Utils.LeadFactory;

public class LeadDataProvider {
    @DataProvider(name = "leadDataProvider")
    public static Object[][] testData() {
        return new Object[][] {{LeadFactory.getMandatoryInfoOnlyLead()},
                {LeadFactory.getFullInfoLead()}, {LeadFactory.getHalfInfoLead()}};
    }
}
