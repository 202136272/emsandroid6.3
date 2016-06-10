package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.AdministratorTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.StationTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.BallisticTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.BiologyTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.ExhibitTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.InvestigatingOfficerTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PersonTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PreciousMetalsTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDocTest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.ScientificTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdministratorTest.class,
        ExhibitTest.class,
        InvestigatingOfficerTest.class,
        PersonTest.class,
        StationTest.class,
        BallisticTest.class,
        BiologyTest.class,
        PreciousMetalsTest.class,
        ScientificTest.class,
        QuestionedDocTest.class
})

public class FactoryTestSuite {

}