package com.github;

import org.junit.*;

public class AboutAnnotationsTestSuite {
    //перед тем как выполнять все методы необходимо выполнить условия в beforeClassMethod.
    @BeforeClass
    public void beforeClassMethod() {
    }

    //запускается перед каждым тестовым методом.
    @Before
    public void setUp() {
    }

    @Test //тесты
    public void testMethod() {
    }

    @Test
    @Ignore //игнорирует тест, не запускает тест
    public void testMethod2() {
    }

    //запускается после каждого тестового метода.
    @After
    public void tearDown() {
    }

    //после того как выполнились все методы необходимо выполнить условия в afterClassMethod.
    @AfterClass
    void afterClassMethod() {
    }

}
