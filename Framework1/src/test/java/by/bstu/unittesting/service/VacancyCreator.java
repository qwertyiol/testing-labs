package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Vacancy;

public class VacancyCreator {
    public static final String TESTDATA_VACANCY_OSTROVEC = "testdata.vacancy.Ostrovec";
    public static final String TESTDATA_VACANCY_BORISOV = "testdata.vacancy.Borisov";

    public static Vacancy createVacancyInBorisov() {
        return new Vacancy(TestDataReader.getTestData(TESTDATA_VACANCY_BORISOV));
    }

    public static Vacancy createVacancyInOstrovec() {
        return new Vacancy(TestDataReader.getTestData(TESTDATA_VACANCY_OSTROVEC));
    }
}
