package com.amdocs;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ RPNCalculatorTest.class, TestClass2.class })
@IncludeCategory(SmokeTest.class)

public class AllTests {

}
